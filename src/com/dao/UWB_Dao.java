package com.dao;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.ibatis.session.SqlSession;
import com.bean.UWB_Data;
import com.db.DbAcess;

public class UWB_Dao {
	public void insertUWBData(UWB_Data uwbData) {
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		try {
			ss = dba.getSqlSession();
			uwbData.setTime(getNow());
			ss.insert("UWBData.insert",uwbData);
			ss.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
	}

	public UWB_Data getOneUWBData()
	{
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		UWB_Data  uwbData = null;
		try {
			ss = dba.getSqlSession();
			//ͨ��ssִ��sql���
			uwbData = ss.selectOne("UWBData.listone");
			System.out.println(uwbData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ss != null) {
				ss.close();
			}
		}
		return uwbData;
	}

	public String getNow() {
		//����һ�����ڶ���
		Date d=new Date();
		/*//����һ����ʽ������
        SimpleDateFormat sdf=new SimpleDateFormat();
        System.out.println(sdf);*/
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//��ʽ��Ϊ����/ʱ���ַ���
		String cc=sdf.format(d);
		return cc;
	}


	public static void main(String[] args) {
		//new Sensor_Dao().insertSensorData(null);
		new UWB_Dao().process("1,222");
	}

	public UWB_Data process(String out) {
		// TODO Auto-generated method stub
		double x = Double.parseDouble(out.substring(0,out.indexOf(",")));
		double y = Double.parseDouble(out.substring(out.indexOf(",")+1));
//		System.out.println(x+","+y);
		UWB_Data uwbD = new UWB_Data();
		uwbD.setX(x);
		uwbD.setY(y);
		return uwbD;
	}
}
