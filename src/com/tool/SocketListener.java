package com.tool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

public class SocketListener {
	public String readSocket() {
		String ip = "192.168.16.254";
		int port = 8080;	
		try {
			Socket socket = new Socket(ip,port);
	        InputStream is = socket.getInputStream();
			while(true)
			{
				byte[] arr = new byte[15];
		        int len = is.read(arr);
		        System.out.println(arr.length);
		        System.out.println(this.BinaryToHexString(arr));
		        
		        try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
