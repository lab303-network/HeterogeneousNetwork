package com.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.LoRa_Station;
import com.bean.Sensor_Data;
import com.dao.LoRa_Dao;
import com.dao.LoRa_StationDao;
import com.dao.Sensor_Dao;
import com.tool.SeialProcess;
import com.tool.SerialListener;

import gnu.io.SerialPort;
import net.sf.json.JSONArray;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		// 测试用代码驱动COM7口发送，COM8口是否能够接受到数据
		//		String sed = "Hello";
		//		ArrayList<String> portList = SeialProcess.findPort();
		//		while (true) {
		//			SerialPort port = SeialProcess.openPort(portList.get(0),115200);
		//			SeialProcess.sendToPort(port ,txt.getBytes());
		//			SeialProcess.closePort(port);
		//			Thread.sleep(6000);
		//		}
		//		

//		 测试COM7发送数据，代码监听COM8口的数据
//		byte[] rec = null;
//		ArrayList<String> portList = SeialProcess.findPort();
//		SerialPort port = SeialProcess.openPort(portList.get(1),115200);
//		//rec = SeialProcess.readFromPort(port);


		//new LoRa_StationDao().queryLoraStationList();
        //List<LoRa_Station> lora_list = new LoRa_Dao().getLoRaData();
        //System.out.println(lora_list);
		//new SerialListener();
		

		 
		
		

	}
}
