package com.sen.test.coursemodule;

import com.sen.dao.impl.CourseModuleDAOJdbcImpl;
import com.sen.view.CourseModule;

public class TestFindOneCourseModule {

	public static void main(String[] args) throws Exception {

		CourseModule uv1 = new CourseModuleDAOJdbcImpl().findByOne(Long.valueOf(61));
		System.out.println("FindOne:" + uv1);

	}

}
