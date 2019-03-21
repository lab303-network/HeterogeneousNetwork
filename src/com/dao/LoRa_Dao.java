package com.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.LoRa_Data;
import com.bean.LoRa_Station;
import com.db.DbAcess;

public class LoRa_Dao {
	public void insert_LoRa_Data(LoRa_Data ld){
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		LoRa_Station ls = null;
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			ld.setMsg("Hello");
			ld.setTerminalId(1); //网页端传回
			ld.setTime(this.getNow());
			ss.insert("LoraData.insert",ld);
			ss.commit();
			System.out.println("插入数据成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
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
	
	public List<LoRa_Station> getLoRaData(){
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<LoRa_Station> ls = null;
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			ls = ss.selectList("LoraStation.findall",1);//此处的1需要由网页端回传
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return ls;
	}
}