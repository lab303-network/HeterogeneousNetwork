package com.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.dao.LoRa_Dao;
import com.dao.LoRa_StationDao;
import com.tool.SeialProcess;
import com.tool.SerialListener;

import gnu.io.SerialPort;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		// �����ô�������COM7�ڷ��ͣ�COM8���Ƿ��ܹ����ܵ�����
		//		String sed = "Hello";
		//		ArrayList<String> portList = SeialProcess.findPort();
		//		while (true) {
		//			SerialPort port = SeialProcess.openPort(portList.get(0),115200);
		//			SeialProcess.sendToPort(port ,txt.getBytes());
		//			SeialProcess.closePort(port);
		//			Thread.sleep(6000);
		//		}
		//		

//		 ����COM7�������ݣ��������COM8�ڵ�����
//		byte[] rec = null;
//		ArrayList<String> portList = SeialProcess.findPort();
//		SerialPort port = SeialProcess.openPort(portList.get(1),115200);
//		//rec = SeialProcess.readFromPort(port);


		//new LoRa_StationDao().queryLoraStationList();
		new LoRa_Dao().getLoRaData();
		//new SerialListener();
		 
		
		

	}
}