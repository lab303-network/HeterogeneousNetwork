package com.tool;

import com.bean.LoRa_Data;

public class DataProcess {
	public LoRa_Data loradata_process(String str) {
		//SNR£º8  RSSI: -33.874800
		LoRa_Data ld = null;
		String str_snr = str.substring(str.lastIndexOf("SNR"), str.indexOf("RSSI")).trim();
		String str_rssi = str.substring(str.indexOf("RSSI"));
		double snr = Double.parseDouble(str_snr.substring(str_snr.indexOf("£º")+1));
		double rssi = Double.parseDouble(str_rssi.substring(str_rssi.indexOf(":")+2));
		System.out.println(snr);
		System.out.println(rssi);
		ld = new LoRa_Data(snr, rssi);
		return ld;
	}
//	public static void main(String[] args) {
//		new DataProcess().loradata_process("SNR£º8  RSSI: -33.874800");
//	}
}

