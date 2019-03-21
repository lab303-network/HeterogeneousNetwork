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
			//ͨ��ssִ��sql���
			ls = ss.selectOne("LoraStation.find1",1);//�˴���1��Ҫ����ҳ�˻ش�
			ld.setMsg("Hello");
			ld.setStationid(ls.getId());
			ld.setTime(this.getNow());
			System.out.println(ld.getTime());
			ss.insert("LoraData.insert",ld);
			ss.commit();
			System.out.println("�������ݳɹ�");
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
	
	public List<LoRa_Data> getLoRaData(){
		DbAcess dba = new DbAcess();
		SqlSession ss = null;
		List<LoRa_Data> ls = null;
		try {
			ss = dba.getSqlSession();
			//ͨ��ssִ��sql���
			ls = ss.selectList("LoraData.list",1);//�˴���1��Ҫ����ҳ�˻ش�
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