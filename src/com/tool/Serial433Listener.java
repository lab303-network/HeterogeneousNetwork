package com.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.TooManyListenersException;

import com.dao.LoRa_Dao;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class Serial433Listener implements SerialPortEventListener{

	byte[] rec = null;
	SerialPort port =null;
	SerialPort port2 = null;
	InputStream ip = null;
	// 设置监听口
	static final String serial433SendPort = "COM8";
	static final String serial433RecPort = "COM9";
	public Serial433Listener() {
		
		port = SeialProcess.openPort(serial433SendPort,115200);
		port2 = SeialProcess.openPort(serial433RecPort,115200);

		if (port != null) {
			try {
				System.out.println("正在监听串口"+port.getName());
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
        int availableBytes = 0;
        
        //如果是数据可用的时间发送，则进行数据的读写
        if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			try {
	        	ip = port.getInputStream();
				int bufflenth;
				bufflenth = ip.available();
				while (bufflenth != 0) {                             
					rec = new byte[bufflenth];    //初始化byte数组为buffer中数据的长度
					ip.read(rec);
					bufflenth = ip.available();
				} 
				if (rec != null ) // 此处填写语句条件
				{
					SeialProcess.sendToPort(port2, rec);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

        }	
	}

}
