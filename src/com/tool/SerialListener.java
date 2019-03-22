package com.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;

import com.dao.LoRa_Dao;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialListener implements SerialPortEventListener{
	byte[] rec = null;
	SerialPort port =null;
	InputStream ip = null;
	public SerialListener() {
		//ArrayList<String> portList = SeialProcess.findPort();
		
		port = SeialProcess.openPort("COM8",115200);
		
		if (port != null) {
			try {
				System.out.println("正在监听串口");
	            //向串口添加事件监听对象。
				port.addEventListener(this);
	            //设置当端口有可用数据时触发事件，此设置必不可少。
				port.notifyOnDataAvailable(true);
			} catch (TooManyListenersException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void serialEvent(SerialPortEvent arg0) {
		// TODO Auto-generated method stub
        int availableBytes = 0;
        
        //如果是数据可用的时间发送，则进行数据的读写
        if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			try {
				System.out.println("===");
	        	ip = port.getInputStream();
				int bufflenth;
				bufflenth = ip.available();
				while (bufflenth != 0) {                             
					rec = new byte[bufflenth];    //初始化byte数组为buffer中数据的长度
					ip.read(rec);
					bufflenth = ip.available();
				} 
				if (rec != null )
				{
					new LoRa_Dao().insert_LoRa_Data(new DataProcess().loradata_process(new String(rec)));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

        }	
	}

}
