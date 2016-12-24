package com.sen.test.course;

import com.sen.dao.CourseDetailDAO;
import com.sen.dao.impl.CourseDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;

public class TestUpdateCourse {

	public static void main(String[] args) throws Exception {
		
		CourseDetail cd =new CourseDetailDAOJdbcImpl().findByOne(Long.valueOf(39));
		cd.setCourseName("javaa");
		cd.setDescription("JaaaSen");
		CourseDetailDAO dao = new CourseDetailDAOJdbcImpl();
		dao.update(cd);
		System.out.println("Updated:" + dao);

	}

}
