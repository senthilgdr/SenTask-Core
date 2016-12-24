package com.sen.test.coursemodule;

import com.sen.dao.CourseModuleDAO;
import com.sen.dao.impl.CourseModuleDAOJdbcImpl;
import com.sen.view.CourseDetail;
import com.sen.view.CourseModule;

public class TestInsertCourseModule {

	public static void main(String[] args) throws Exception {

		CourseModule cm = new CourseModule();

		CourseDetail cd = new CourseDetail();
		cd.setCourseId(Long.valueOf(40));
		cm.setCourseDetail(cd);

		cm.setModuleName("J2");
		cm.setDesc("Java");
		cm.setRank(Long.valueOf(3));

		cm.setCreatedBy(Long.valueOf(1));

		CourseModuleDAO dao = new CourseModuleDAOJdbcImpl();
		dao.insert(cm);
		System.out.println("Inserted:" + dao);

	}

}
