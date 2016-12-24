package com.sen.test.usertype;

import com.sen.dao.impl.UserTypeDAOJdbcImpl;
import com.sen.view.UserType;

public class TestFindOneUserType {

	public static void main(String[] args) throws Exception {
		
		UserType uv1 = new UserTypeDAOJdbcImpl().findByOne(Long.valueOf(2));
		System.out.println(uv1);
		
		
	}

}
