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
	// ���ü�����
	static final String serial433SendPort = "COM8";
	static final String serial433RecPort = "COM9";
	public Serial433Listener() {
		
		port = SeialProcess.openPort(serial433SendPort,115200);
		port2 = SeialProcess.openPort(serial433RecPort,115200);

		if (port != null) {
			try {
				System.out.println("���ڼ�������"+port.getName());
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
        int availableBytes = 0;
        
        //��������ݿ��õ�ʱ�䷢�ͣ���������ݵĶ�д
        if(arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE){
			try {
	        	ip = port.getInputStream();
				int bufflenth;
				bufflenth = ip.available();
				while (bufflenth != 0) {                             
					rec = new byte[bufflenth];    //��ʼ��byte����Ϊbuffer�����ݵĳ���
					ip.read(rec);
					bufflenth = ip.available();
				} 
				if (rec != null ) // �˴���д�������
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
