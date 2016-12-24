package com.sen.test.usertype;

import java.util.List;

import com.sen.dao.UserTypeDAOJdbcImpl;
import com.sen.view.UserType;

public class TestSelectUserType {

	public static void main(String[] args) throws Exception {

		List<UserType> list = new UserTypeDAOJdbcImpl().findAll();
		for (UserType uv : list) {
			System.out.println(uv);
		}

	}

}
