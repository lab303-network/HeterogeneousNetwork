package com.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.bean.Sensor;
import com.bean.Sensor_Data;
import com.db.DbAcess;
import com.tool.DataProcess;

public class Sensor_Dao {
	public ArrayList<ArrayList<Sensor_Data>> getSensorData(){
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<Sensor_Data> ls = null;
		List<String> sensorid = null;
		ArrayList<ArrayList<Sensor_Data>> out = new ArrayList<ArrayList<Sensor_Data>>();
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			sensorid = ss.selectList("SensorData.listsensorid");
			for (int i = 0; i < sensorid.size(); i++) {
				ls = ss.selectList("SensorData.list",sensorid.get(i));
				out.add((ArrayList<Sensor_Data>) ls);
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return out;
	}
	//返回拓扑list  第一个为本身id，第二个为父节点id
	public ArrayList<ArrayList<String>> getTopo() {
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<Sensor> ls = null;
		ArrayList<ArrayList<String>> topo = new ArrayList<ArrayList<String>>();
		try {
			ss = dba.getSqlSession();
			ls = ss.selectList("SensorData.listtopo");
			for (int i = 0; i < ls.size(); i++) {
				for (int j = 0 ;j<ls.size();j++)
				{
					if (ls.get(i).getFather_addr().equals(ls.get(j).getSensor_addr())) {
						ArrayList<String> temp = new ArrayList<String>();
						temp.add(ls.get(i).getSensor_id());
						temp.add(ls.get(j).getSensor_id());
						topo.add(temp);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return topo;
	}
	
	// 查看传感器是否在传感器列表里面
	public boolean isSensorExit(Sensor_Data in) {
		List<String> SensorIdList = new ArrayList<String>() ;
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			SensorIdList = ss.selectList("SensorData.listsensorid");
			for (int i=0; i<SensorIdList.size();i++)
			{
				if (SensorIdList.get(i).equals(in.getSensor_id()))
					return true;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return false;
	}
	
	// 检查是否离开zigbee范围，输入：一段时间的数据包， 输出：离开的终端的id
	public List<String> isSensorOut(List<String> list) {
		List<Sensor_Data> list_sd = new DataProcess().sensordata_process(list);
		List<String> list_sensorid = new ArrayList<String>() ;
		list_sensorid.add("0000");//默认0000不会离开
		for (int i = 0; i < list_sd.size(); i++) {
			list_sensorid.add(list_sd.get(i).getSensor_id());	
		}
		List<String> SensorIdList = new ArrayList<String>() ;
		List<String> leave = new ArrayList<String>() ;
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		try {
			ss = dba.getSqlSession();
			//通过ss执行sql语句
			SensorIdList = ss.selectList("SensorData.listsensorid");
			for (int i=0; i<SensorIdList.size();i++)
			{
				if(list_sensorid.contains(SensorIdList.get(i)))
					continue;
				else
				{
					leave.add(SensorIdList.get(i));
					//将离开的终端的isLeave置1
					ss.update("SensorData.updateforleave",SensorIdList.get(i));
					ss.commit();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return leave;
	}
					
	public void insertSensorData(List<Sensor_Data> list) {
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		try {
			ss = dba.getSqlSession();
//测试用
//			ss.update("SensorData.updatesensor", new Sensor("0000","0000","0000"));
//			ss.insert("SensorData.insertnewsensor",new Sensor("1234","0000","0000"));
//			ss.insert("SensorData.insert", new Sensor_Data("0000","0000","0000","0000",new Sensor("1234","0000","0000")));
			
			
			for (int i =0; i<list.size();i++)
			{
				if (this.isSensorExit(list.get(i))) {
					ss.update("SensorData.updatesensor", list.get(i).getSensor());
					//System.out.println("更新topo关系成功");
				}else {
					ss.insert("SensorData.insertnewsensor",list.get(i).getSensor());
					System.out.println("新增新的终端:"+list.get(i).getSensor().getSensor_id());
				}
				ss.commit();
				ss.insert("SensorData.insert", list.get(i));
				ss.commit();
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
	
	public static void main(String[] args) {
		//new Sensor_Dao().insertSensorData(null);
		new Sensor_Dao().getSensorData();
	}
}
