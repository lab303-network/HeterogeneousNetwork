package com.tool;

import java.io.IOException;
import java.io.InputStream;
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
import com.dao.UWB_Dao;

// UWB
public class UWBSocketListener {
	public List<String> readSocket() {
		String ip = "172.20.10.6";
		int port = 8123;	
		String out = null;
		Socket socket = null;
		InputStream is = null;	  
		OutputStream out2server = null;
		try {
			socket = new Socket(ip,port);
			System.out.println("正在监听UWB网口");
			is = socket.getInputStream();	  
			while(true)
			{
				byte[] arr = new byte[1024];
				int len = is.read(arr);
				if(len >= 33)
					len = 33;
				out =  new String(Arrays.copyOf(arr, len));
				//测试用
				System.out.println(out);
				// 处理数据
				new UWB_Dao().insertUWBData(new UWB_Dao().process(out));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}


	

	public static void main(String[] args) {
		new UWBSocketListener().readSocket();
	}
}

