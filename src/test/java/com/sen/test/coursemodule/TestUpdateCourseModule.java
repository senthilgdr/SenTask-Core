package com.sen.test.coursemodule;

import com.sen.dao.CourseModuleDAO;
import com.sen.dao.CourseModuleDAOJdbcImpl;
import com.sen.view.CourseDetail;
import com.sen.view.CourseModule;

public class TestUpdateCourseModule {

	public static void main(String[] args) throws Exception {

		CourseModule uv = new CourseModuleDAOJdbcImpl().findByOne(Long.valueOf(64));

		CourseDetail cd1 = new CourseDetail();
		cd1.setCourseId(Long.valueOf(10));

		uv.setCourseDetail(cd1);

		uv.setModuleName("J2EE");
		uv.setDesc("Java");
		uv.setRank(Long.valueOf(3));
		uv.setModifiedBy(Long.valueOf(1));

		CourseModuleDAO dao1 = new CourseModuleDAOJdbcImpl();
		dao1.update(uv);
		System.out.println("Updated:" + dao1);

	}

}
