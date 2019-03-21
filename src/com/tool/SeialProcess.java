package com.tool;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class SeialProcess{
	private static SeialProcess serialTool = null;
	
	static {
		//�ڸ��౻ClassLoader����ʱ�ͳ�ʼ��һ��SerialTool����
		if (serialTool == null) {
			serialTool = new SeialProcess();
		}
	}

	//˽�л�SerialTool��Ĺ��췽��������������������SerialTool����
	private SeialProcess() {
		
	}    

	/**
	 * ��ȡ�ṩ�����SerialTool����
	 * @return serialTool
	 */
	public static SeialProcess getSerialTool() {
		if (serialTool == null) {
			serialTool = new SeialProcess();
		}
		return serialTool;
	}


	/**
	 * �������п��ö˿�
	 * @return ���ö˿������б�
	 */
	public static final ArrayList<String> findPort() {

		//��õ�ǰ���п��ô���
		Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();    

		ArrayList<String> portNameList = new ArrayList<>();

		//�����ô�������ӵ�List�����ظ�List
		while (portList.hasMoreElements()) {
			String portName = portList.nextElement().getName();
			portNameList.add(portName);
		}

		return portNameList;
	}

	/**
	 * �򿪴���
	 * @param portName �˿�����
	 * @param baudrate ������
	 * @return ���ڶ���
	 * @throws SerialPortParameterFailure ���ô��ڲ���ʧ��
	 * @throws NotASerialPort �˿�ָ���豸���Ǵ�������
	 * @throws NoSuchPort û�иö˿ڶ�Ӧ�Ĵ����豸
	 * @throws PortInUse �˿��ѱ�ռ��
	 */
	public static final SerialPort openPort(String portName, int baudrate)  {


		//ͨ���˿���ʶ��˿�
		CommPortIdentifier portIdentifier;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

			//�򿪶˿ڣ������˿����ֺ�һ��timeout���򿪲����ĳ�ʱʱ�䣩
			CommPort commPort = portIdentifier.open(portName, 2000);

			//�ж��ǲ��Ǵ���
			if (commPort instanceof SerialPort) {

				SerialPort serialPort = (SerialPort) commPort;

				//����һ�´��ڵĲ����ʵȲ���
				serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);                              

				System.out.println("Open " + portName + " sucessfully !");
				return serialPort;
			}
		} catch (NoSuchPortException | PortInUseException | UnsupportedCommOperationException e) {
			// TODO Auto-generated catch block
			System.out.println(portName+"����ռ��");
			e.printStackTrace();
		}
		return null;		
	}

	/**
	 * �����ڷ�������
	 * @param serialPort ���ڶ���
	 * @param order    ����������
	 * @throws SendDataToSerialPortFailure �򴮿ڷ�������ʧ��
	 * @throws SerialPortOutputStreamCloseFailure �رմ��ڶ�������������
	 */
	public static void sendToPort(SerialPort serialPort, byte[] order) {

		OutputStream out = null;
		try {
			out = serialPort.getOutputStream();
			out.write(order);
			out.flush();
			System.out.println("Data Sent");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * �رմ���
	 * @param serialport ���رյĴ��ڶ���
	 */
	public static void closePort(SerialPort serialPort) {
		if (serialPort != null) {
			serialPort.close();
			serialPort = null;
		}
	}

	/**
	 * �Ӵ��ڶ�ȡ����
	 * @param serialPort ��ǰ�ѽ������ӵ�SerialPort����
	 * @return ��ȡ��������
	 * @throws ReadDataFromSerialPortFailure �Ӵ��ڶ�ȡ����ʱ����
	 * @throws SerialPortInputStreamCloseFailure �رմ��ڶ�������������
	 */
	public static byte[] readFromPort(SerialPort serialPort)  {

		InputStream in = null;
		byte[] bytes = null;

		try {
			while(true) {
				in = serialPort.getInputStream();
				int bufflenth = in.available();        //��ȡbuffer������ݳ���

				while (bufflenth != 0) {                             
					bytes = new byte[bufflenth];    //��ʼ��byte����Ϊbuffer�����ݵĳ���
					in.read(bytes);
					bufflenth = in.available();
				} 
				if (bytes != null )
				{
					System.out.println(new String(bytes));
				}else {
					continue;
				}
				Thread.sleep(1000);
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

		return bytes;

	}
}




