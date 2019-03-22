package com.tool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bean.LoRa_Data;
import com.bean.Sensor;
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
	public List<Sensor_Data> sensordata_process(List<String> list) {
		List<Sensor_Data> output = new ArrayList<Sensor_Data>();
		for (int i = 0; i<list.size();i++)
		{
			String str = list.get(i).replaceAll(" ", ""); //去除所有空格
			String sensor_id = str.substring(0,4);
			String data = String.valueOf(Integer.parseInt(str.substring(4,str.indexOf("010C")),16));
			String sensor_addr = str.substring(str.lastIndexOf("010C")+4,str.lastIndexOf("010C")+8);
			String father_addr = str.substring(str.lastIndexOf("010C")+8,str.lastIndexOf("010C")+12);
			String rssi = String.valueOf(Integer.parseInt("-"+str.substring(str.indexOf("0D0A")-2,str.indexOf("0D0A")),16));
			Sensor_Data sd = new Sensor_Data(sensor_id, data, this.getNow(),rssi,new Sensor(sensor_id,sensor_addr,father_addr));
			
			// 错误包  --  抛弃
			//System.out.println(str.length());  30
			if(str.length() != 30)
				break;
			output.add(sd);
			
//			System.out.println(sensor_id);
//			System.out.println(data);
//			System.out.println(sensor_addr);
//			System.out.println(father_addr);
//			System.out.println(rssi);
		}
		return output;
	}
	
	public String getNow() {
		//创建一个日期对象
        Date d=new Date();
        /*//创建一个格式化对象
        SimpleDateFormat sdf=new SimpleDateFormat();
        System.out.println(sdf);*/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //格式化为日期/时间字符串
        String cc=sdf.format(d);
        return cc;
	}
	
	
	
	public static void main(String[] args) {
		//new DataProcess().loradata_process("SNR：8  RSSI: -33.874800");
//		List<String> list = new ArrayList<String>();
//		list.add("BB 0B 01 43 01 0C CC 4B 00 00 27 0D 0A 0D 0A");
//		new DataProcess().sensordata_process(list);
//		System.out.println(Integer.parseInt("0143",16));

	}
}

