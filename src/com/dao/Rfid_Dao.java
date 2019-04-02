package com.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Rfid_Data;
import com.bean.Sensor_Data;
import com.db.DbAcess;

public class Rfid_Dao {

	//RFID信息插入
	public void insert_rfid(List<String> rfidList) {
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		ArrayList<ArrayList<Sensor_Data>> out = new ArrayList<ArrayList<Sensor_Data>>();
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			for (int i = 0; i < rfidList.size(); i++) {
				Rfid_Data rf = new Rfid_Data(rfidList.get(i),1,this.getNow());
				ss.insert("RfidData.insert",rf);
				ss.commit();
				System.out.println("插入成功");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
	}

	//RFID信息查询
	public List<String> listRfid(){
		String now = this.getNow();
		String now1 = this.getNow_1(1);
		String now2 = this.getNow_1(2);
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<String> list = new ArrayList<String>();
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		try {
			ss = dba.getSqlSession();
//			list = ss.selectList("RfidData.list1", "2019-04-01 22:40:04");
//			list1 = ss.selectList("RfidData.list1", "2019-04-01 22:40:05");
//			list2 = ss.selectList("RfidData.list1", "2019-04-01 22:40:06");
			list = ss.selectList("RfidData.list1", now2);
			list1 = ss.selectList("RfidData.list1", now1);
			list2 = ss.selectList("RfidData.list1", now);
			list1.addAll(list2);
			list.addAll(list1);
			list = this.deletSame(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return list;
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

	public String getNow_1(int i) {
		Date d = new Date(System.currentTimeMillis()-i*1000); 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cc=sdf.format(d);
		return cc;
	}
	public List<String>deletSame(List<String> list) {
		HashSet h = new HashSet(list);   
		list.clear();   
		list.addAll(h);   
		return list;
		 
	}
	public static void main(String[] args) {
		//		new Rfid_Dao().insert_rfid(rfidList);
		//		new Rfid_Dao().getNow();
		new Rfid_Dao().listRfid();
	}
}
