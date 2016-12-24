package com.sen.test.usercourse;

import java.util.List;

import com.sen.dao.UserCourseDAO;
import com.sen.dao.impl.UserCourseDAOJdbcImpl;
import com.sen.view.UserCourse;

public class TestUserCourseDAO {

	public static void main(String[] args) throws Exception {
	
		
		UserCourseDAO userCourseDAO = new UserCourseDAOJdbcImpl();
		
		List<UserCourse> courseList = userCourseDAO.findByUserId(5L);
		
		System.out.println("No of courses:" + courseList.size());
		
		for (UserCourse userCourse : courseList) {
			System.out.println(userCourse);
		}

	}

}
