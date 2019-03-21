package com.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbAcess {
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接相关信息
		Reader reader = Resources.getResourceAsReader("com/configuration/Configuration.xml");
		
		// 通过配置信息构建sqlsession
		SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
		
		// 通过ss打开一个会话
		SqlSession ss = ssf.openSession();
		return ss;
		
	}
}
