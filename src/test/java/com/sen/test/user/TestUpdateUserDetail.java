package com.sen.test.user;

import com.sen.dao.UserDetailDAO;
import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;
import com.sen.view.UserType;

public class TestUpdateUserDetail {

	public static void main(String[] args) throws Exception {

		UserDetail ud = new UserDetailDAOJdbcImpl().findByOne(Long.valueOf(61));

		ud.setName("Senthil");
		ud.setUserName("senthilkumar");
		ud.setPassWord("admin");
		ud.setEmailId("kaja@gmail.com");

		UserType ut = new UserType();
		ut.setUserTypeId(Long.valueOf(1));
		ud.setUserType(ut);

		ud.setCreatedBy(Long.valueOf(1));

		UserDetailDAO dao1 = new UserDetailDAOJdbcImpl();
		dao1.update(ud);
		System.out.println("Updated:" + dao1);

	}

}
