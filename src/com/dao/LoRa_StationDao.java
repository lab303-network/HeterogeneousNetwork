package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.LoRa_Station;
import com.db.DbAcess;

public class LoRa_StationDao {
	public List<LoRa_Station> queryLoraStationList(){
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<LoRa_Station> list = new ArrayList<LoRa_Station>();
		try {
			ss = dba.getSqlSession();
			//ͨ��ssִ��sql���
			list = ss.selectList("LoraStation.find");
			System.out.println(list.get(0).getX());
			ss.insert("LoraStation.insert",new LoRa_Station(2,3));
			ss.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		
		return null;
		
	}
}
