package com.sen.test.coursemodule;

import com.sen.dao.CourseModuleDAO;
import com.sen.dao.impl.CourseModuleDAOJdbcImpl;
import com.sen.view.CourseModule;

public class TestDeleteCourseModule {

	public static void main(String[] args) throws Exception {

		CourseModule cm = new CourseModule();
		cm.setCourseModuleId(Long.valueOf(62));
		cm.setModifiedBy(Long.valueOf(2));
		CourseModuleDAO dao2 = new CourseModuleDAOJdbcImpl();
		dao2.delete(cm);
		System.out.println("Deleted");

	}

}
