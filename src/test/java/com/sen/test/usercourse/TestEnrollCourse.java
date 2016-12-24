package com.sen.test.usercourse;

import com.sen.dao.UserCourseDAO;
import com.sen.dao.UserDetailDAO;
import com.sen.dao.impl.UserCourseDAOJdbcImpl;
import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;
import com.sen.view.UserCourse;
import com.sen.view.UserDetail;

public class TestEnrollCourse {

	public static void main(String[] args) throws Exception {

		UserDetailDAO dao = new UserDetailDAOJdbcImpl();

		UserDetail userDetail = dao.findByOne(5L);
		UserCourse uc = new UserCourse();
		
		CourseDetail course = new CourseDetail();
		course.setCourseId(1L);
		
		uc.setCourse(course);
		uc.setUserDetail(userDetail);
		
		UserCourseDAO um = new UserCourseDAOJdbcImpl();
		
		um.courseEnroll(uc);
		System.out.println("Enroll :" + userDetail);

	}

}
