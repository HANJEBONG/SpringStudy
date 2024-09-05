package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDAO2;

@Configuration
public class EmpConfig {
	/*
	 * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
		p:driverClassName="oracle.jdbc.driver.OracleDriver"
		p:url="jdbc:oracle:thin:@localhost:1521:XE"
		p:username="hr"
		p:password="happy"
	></bean>
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	@Bean
	public  MapperFactoryBean mapperFactoryBean() {
		MapperFactoryBean mapper=new MapperFactoryBean();
		try {
			mapper.setSqlSessionFactory(sqlSessionFactory());
			mapper.setMapperInterface(com.sist.mapper.EmpMapper.class);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mapper;
	}
	
}
