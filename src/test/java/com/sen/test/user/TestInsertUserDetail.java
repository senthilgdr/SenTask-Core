package com.sen.test.user;

import com.sen.dao.UserDetailDAO;
import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserDetail;
import com.sen.view.UserType;

public class TestInsertUserDetail {

	public static void main(String[] args) throws Exception {
	
		UserDetail uv2 = new UserDetail();
		uv2.setName("Naresh");
		uv2.setUserName("naresh");
		uv2.setPassWord("pass123");
		uv2.setEmailId("csenaresh@gmail.com");
			
		UserType ut=new UserType();
		ut.setUserTypeId(Long.valueOf(1));
		
		uv2.setUserType(ut);
		
		Long defaultUserId = 1L;
		uv2.setCreatedBy(defaultUserId);
		
		UserDetailDAO dao=new UserDetailDAOJdbcImpl();
		dao.insert(uv2);
		System.out.println("Inserted:"+dao);		
		
		
	}

}
