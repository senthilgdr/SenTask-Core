package com.sen.test.usertype;

import com.sen.dao.UserTypeDAO;
import com.sen.dao.UserTypeDAOJdbcImpl;
import com.sen.view.UserType;

public class TestDeleteUserType {

	public static void main(String[] args) throws Exception {
		
		UserType ut=new UserType();
		ut.setUserTypeId(Long.valueOf(5));
		
		UserTypeDAO dao2=new UserTypeDAOJdbcImpl();
		dao2.delete(ut);
		System.out.println("Deleted:"+dao2);

	}

}
