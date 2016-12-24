package com.sen.test.course;

import java.util.List;

import com.sen.dao.CourseDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;

public class TestSelectCourse {

	public static void main(String[] args) throws Exception {
		
		List<CourseDetail> list = new CourseDetailDAOJdbcImpl().findAll();
		for (CourseDetail cd : list) {
			System.out.println(cd);
		}
	}

}
