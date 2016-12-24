package com.sen.test.user;

import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;

public class TestLoginUserDetail {

	public static void main(String[] args) throws Exception {
		String userName="srini";
		String passWord="srini";

		UserDetail uv1 = new UserDetailDAOJdbcImpl().isValidLogin(userName, passWord);
		System.out.println("Login:" + uv1);

	}

}
