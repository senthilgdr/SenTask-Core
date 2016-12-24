package com.sen.test.user;

import java.util.List;

import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;


public class TestSelectUserDetail {

	public static void main(String[] args) throws Exception {

		List<UserDetail> list = new UserDetailDAOJdbcImpl().findAll();
		for (UserDetail uv : list) {
			System.out.println(uv);
		}

	}

}
