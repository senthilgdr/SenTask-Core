package com.sen.test.course;

import com.sen.dao.CourseDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;


public class TestFindOneCourse {

	public static void main(String[] args) throws Exception {
		
        CourseDetail cd = new CourseDetailDAOJdbcImpl().findByOne(Long.valueOf(1));
		System.out.println("FindOne:"+cd);
		
	}

}
