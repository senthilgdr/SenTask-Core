package com.sen.test.usertype;

import java.sql.SQLException;

import com.sen.dao.UserTypeDAO;
import com.sen.dao.UserTypeDAOJdbcImpl;
import com.sen.view.UserType;

public class TestInsertUserType {

	public static void main(String[] args) throws Exception {

		try {
			UserType ut = new UserType();
			ut.setUserTypeId(Long.valueOf(6));
			ut.setUserType("Manager");
			ut.setOprtnlFlag("A");

			UserTypeDAO dao = new UserTypeDAOJdbcImpl();
			dao.insert(ut);
			System.out.println("Insertd:" + ut);

		} catch (SQLException e) {
			e.printStackTrace();

			throw new Exception(e);
		}

	}

}
