package com.sen.test.util;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.util.ConnectionUtil;



public class TestConnectionUtil {
	public static void main(String[] args) throws Exception {		
		
		JdbcTemplate ds = ConnectionUtil.getJdbcTemplate();
		System.out.println("Connected SuccesFully:" + ds);

	}

}
