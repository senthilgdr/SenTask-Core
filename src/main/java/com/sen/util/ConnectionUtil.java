package com.sen.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionUtil {
	
	
	 public static JdbcTemplate getJdbcTemplate() {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
	        DataSource dataSource = getDataSource();
			jdbcTemplate.setDataSource(dataSource);
	        return jdbcTemplate;
	    }
	 
	    public static DataSource getDataSource() {
	        BasicDataSource ds = new BasicDataSource();
	        ds.setDriverClassName("com.mysql.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/sentask_db");
	        ds.setUsername("root");
	        ds.setPassword("");
	        return ds;
	    }

	
}
