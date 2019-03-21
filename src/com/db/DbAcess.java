package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbAcess {
	public SqlSession getSqlSession() throws IOException {
		// ͨ�������ļ���ȡ���ݿ����������Ϣ
		Reader reader = Resources.getResourceAsReader("com/configuration/Configuration.xml");
		
		// ͨ��������Ϣ����sqlsession
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		
		// ͨ��ss��һ���Ự
		SqlSession ss = ssf.openSession();
		return ss;
		
	}
}
