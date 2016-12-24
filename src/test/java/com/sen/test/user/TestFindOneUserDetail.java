package com.sen.test.user;

import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;

public class TestFindOneUserDetail {

	public static void main(String[] args) throws Exception {

		UserDetail uv1 = new UserDetailDAOJdbcImpl().findByOne(Long.valueOf(3));
		System.out.println("FindOne:" + uv1);

	}

}
