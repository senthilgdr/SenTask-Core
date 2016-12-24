package com.sen.test.user;

import com.sen.dao.UserDetailDAO;
import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;

public class TestDisableAccountUserDetail {

	public static void main(String[] args) throws Exception {

		UserDetail ud = new UserDetailDAOJdbcImpl().findByOne(Long.valueOf(7));
		ud.setOprnlFlag("I");		

		UserDetailDAO dao1 = new UserDetailDAOJdbcImpl();
		dao1.update(ud);
		System.out.println("Updated:" + dao1);

	}

}
