package com.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bean.Sensor_Data;
import com.dao.Sensor_Dao;

public class SocketListener {
	public List<String> readSocket() {
		String ip = "192.168.16.254";
		int port = 8080;	
		String out = null;
		List<String> list = new ArrayList<String>();
		List<String> list_check = new ArrayList<String>();
		List<String> leave = new ArrayList<String>();
		try {
			Socket socket = new Socket(ip,port);
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
	
	public static void main(String[] args) {
		new SocketListener().readSocket();
	}
}
