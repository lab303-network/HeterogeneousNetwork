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
				System.out.println("���ڼ�������");
	            //�򴮿�����¼���������
				port.addEventListener(this);
	            //���õ��˿��п�������ʱ�����¼��������ñز����١�
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
        
        //��������ݿ��õ�ʱ�䷢�ͣ���������ݵĶ�д
        if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			try {
				System.out.println("===");
	        	ip = port.getInputStream();
				int bufflenth;
				bufflenth = ip.available();
				while (bufflenth != 0) {                             
					rec = new byte[bufflenth];    //��ʼ��byte����Ϊbuffer�����ݵĳ���
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
