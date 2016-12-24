package com.sen.test.usercourse;

import com.sen.dao.UserCourseDAO;
import com.sen.dao.impl.UserCourseDAOJdbcImpl;

public class TestUnenrollCourse {

	public static void main(String[] args) throws Exception {

		long userCourseId = 100L;
		
		UserCourseDAO um = new UserCourseDAOJdbcImpl();
		
		um.disableEnrollCourse(userCourseId);
		System.out.println("Disbale:");

	}

}
