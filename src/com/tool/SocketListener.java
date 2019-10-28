package com.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dao.Sensor_Dao;

// ZigBee
public class SocketListener {
	public long writeSocket(String str) throws IOException {
		String ip = "192.168.16.254";
		int port = 8080;	
		Socket socket = null;
		String out = null;
		long jTime = 0;
		try {
			socket = new Socket(ip,port);
			OutputStream os  = socket.getOutputStream();
			InputStream is = socket.getInputStream();	
			//			PrintWriter pw = new PrintWriter(os);
			//			pw.write(str.getBytes());
			Long startTime = System.currentTimeMillis();
			os.write(hexStringToByteArray(str));

			byte[] arr = new byte[1024];
			int len = is.read(arr);
			Long endTime = System.currentTimeMillis();
			out = this.BinaryToHexString(Arrays.copyOf(arr, len));
			//Long endTime = System.currentTimeMillis();
			jTime = endTime - startTime;
			System.out.println(jTime);
			os.close();
			is.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jTime;
	}

	public List<String> readSocket(){
		String ip = "192.168.16.254";
		int port = 8080;	
		String out = null;
		List<String> list = new ArrayList<String>();
		List<String> list_check = new ArrayList<String>();
		List<String> leave = new ArrayList<String>();
		Socket socket = null;
		try {
			socket = new Socket(ip,port);
			System.out.println("正在监听Zigbee网口");
			InputStream is = socket.getInputStream();	        
			long startTime =  System.currentTimeMillis();
			while(true)
			{
				byte[] arr = new byte[1024];
				int len = is.read(arr);
				out = this.BinaryToHexString(Arrays.copyOf(arr, len));

				//测试用
				//System.out.println(out);

				list.add(out);
				list_check.add(out);		     
				long endTime =  System.currentTimeMillis();
				long usedTime = (endTime-startTime)/1000;
				if (usedTime > 2) {
					// 每隔3秒记录一次
					new Sensor_Dao().insertSensorData(new DataProcess().sensordata_process(list));
					list.clear();
				}
				if (usedTime > 6) {
					// 每隔6秒自查一次，是否有终端离开
					leave = new Sensor_Dao().isSensorOut(list_check);
					for (int i = 0; i < leave.size(); i++) {
						//System.out.println(leave.get(i)+"离开了");
					}
					list_check.clear();
					startTime = endTime;
				}
			}	
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public static String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (byte b : bytes) {
			hex = String.valueOf(hexStr.charAt((b & 0xF0) >> 4));
			hex += String.valueOf(hexStr.charAt(b & 0x0F));
			result += hex + " ";
		}
		return result;
	}


	public static byte[] hexStringToByteArray(String hexString) {
		hexString = hexString.replaceAll(" ", "");
		int len = hexString.length();
		byte[] bytes = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			// 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个字节
			bytes[i / 2] = (byte) ((Character.digit(hexString.charAt(i), 16) << 4) + Character
					.digit(hexString.charAt(i + 1), 16));
		}
		return bytes;
	}

	public static void main(String[] args) {
		try {
			// AA 00 01 符和ZigBee规则的字符
			//new SocketListener().readSocket();
			List<Long> list = new ArrayList<Long>();
			for (int i = 0; i < 100 ; i++) {
				long time1 = new SocketListener().writeSocket("AA 00 01");
				list.add(time1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			long all = 0;
			for (int i = 0; i < list.size(); i++) {
				all += list.get(i);
			}
			System.out.println("100次平均值:"+all/list.size()+" ms");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
