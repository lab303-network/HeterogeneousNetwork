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
			//Í¨¹ýssÖ´ÐÐsqlÓï¾ä
			list = ss.selectList("LoraStation.findall1");
//			System.out.println(list.get(0).getId());
//			System.out.println(list.get(0).getX());
//			System.out.println(list.get(0).getY());
//			System.out.println(list.get(0).getTerminals().get(0).getId());


			System.out.println(list.get(0).getTerminals().get(0).getDatas().get(0).getMsg());
			//ss.insert("LoraStation.insert",new LoRa_Station(2,3));
			//ss.commit();
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
