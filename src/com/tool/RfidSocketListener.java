package com.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.Sensor_Data;
import com.dao.Rfid_Dao;
import com.dao.Sensor_Dao;

// RFID socket
public class RfidSocketListener {
	public List<String> readSocket() {
		// 此处作为rfid的客户端
		// 设成静态地址192.168.1.100，连接到TCP server：192.168.1.190:6000
		String ip = "192.168.1.190";
		int port = 6000;	
		String out = null;
		Socket socket = null;
        InputStream is = null;	  
        OutputStream out2server = null;
        List<String> rfidCardList = new ArrayList<String>();
		try {
			socket = new Socket(ip,port);
//			SocketAddress k = new InetSocketAddress("192.168.1.100",6666);
//			socket.bind(k);
			System.out.println("正在监听RFID网口");
	        is = socket.getInputStream();	  
	        out2server = socket.getOutputStream();
	        long startTime =  System.currentTimeMillis();
			while(true)
			{
				byte[] arr = new byte[1024];
		        int len = is.read(arr);
		        out = this.BinaryToHexString(Arrays.copyOf(arr, len)).replaceAll(" ", "");
		        //测试用
		        System.out.println(out);
		        if ((!rfidCardList.contains(out)) && out.length() == 36)
		        	rfidCardList.add(out);
		        System.out.println(rfidCardList.size());
		        long endTime =  System.currentTimeMillis();
		        long usedTime = (endTime-startTime)/1000;
		        if (usedTime > 0.5) {
		        	// 每隔0.5秒记录一次,剔出重复项
		        	if (!rfidCardList.isEmpty())
		        	{
			        	new Rfid_Dao().insert_rfid(rfidCardList);
		        		startTime = endTime;
		        		rfidCardList.clear();
		        	}
		        }
		        if (usedTime > 60) {
		        	// 保证Socket对象存活
		        	out2server.write("Hello".getBytes());
		        	startTime = endTime;
		        }
			}	
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				is.close();
				out2server.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	public static void main(String[] args) {
		new RfidSocketListener().readSocket();
	}
}

