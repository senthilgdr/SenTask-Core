package com.sen.test.user;

import com.sen.dao.UserDetailDAO;
import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;

public class TestDeleteUserDetail {

	public static void main(String[] args) throws Exception {

		UserDetail ud = new UserDetail();
		ud.setUserId(Long.valueOf(3));
		UserDetailDAO dao2 = new UserDetailDAOJdbcImpl();
		dao2.delete(ud);
		System.out.println("Deleted");

	}

}
