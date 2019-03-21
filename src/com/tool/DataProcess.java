package com.tool;

import com.bean.LoRa_Data;
import com.bean.Sensor_Data;

public class DataProcess {
	public LoRa_Data loradata_process(String str) {
		//SNR：8  RSSI: -33.874800
		LoRa_Data ld = null;
		String str_snr = str.substring(str.lastIndexOf("SNR"), str.indexOf("RSSI")).trim();
		String str_rssi = str.substring(str.indexOf("RSSI"));
		double snr = Double.parseDouble(str_snr.substring(str_snr.indexOf("：")+1));
		double rssi = Double.parseDouble(str_rssi.substring(str_rssi.indexOf(":")+2));
		System.out.println(snr);
		System.out.println(rssi);
		ld = new LoRa_Data(snr, rssi);
		return ld;
	}
	
	/**
	 * BB 0B 01 43 01 0C CC 4B 00 00 27 0D 0A 0D 0A 
	 *  BB OB 标识位
	 *  01 43 传感器数据 mv 
	 *  01 0C 邻居关系标识位
	 *  AC 5F CC 4B  前两位 自己   后两位 父亲
	 *  29 RSSI
	 *  0D 0A 0D 0A 换行符
	 */
	public Sensor_Data sensordata_process(String str) {
		
		
		return null;
	}
	
	
	
	
	
//	public static void main(String[] args) {
//		new DataProcess().loradata_process("SNR：8  RSSI: -33.874800");
//	}
}

