package com.sen.test.usertype;

import com.sen.dao.UserTypeDAO;
import com.sen.dao.impl.UserTypeDAOJdbcImpl;
import com.sen.view.UserType;

public class TestUpdateUserType {

	public static void main(String[] args) throws Exception {
	
		UserType uv1 = new UserTypeDAOJdbcImpl().findByOne(Long.valueOf(2));
		System.out.println(uv1);	
		
		uv1.setUserType("Trainer");
		uv1.setOprtnlFlag("A");
		
		UserTypeDAO dao1=new UserTypeDAOJdbcImpl();
		dao1.update(uv1);
		System.out.println("Updated:"+uv1);
		
	

	}

}
