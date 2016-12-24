package com.sen.test.coursemodule;

import java.util.List;

import com.sen.dao.CourseModuleDAOJdbcImpl;
import com.sen.view.CourseModule;

public class TestSelectCourseModule {

	public static void main(String[] args) throws Exception {

		List<CourseModule> list = new CourseModuleDAOJdbcImpl().findAll();
		for (CourseModule uv : list) {
			System.out.println(uv);
		}

	}

}
