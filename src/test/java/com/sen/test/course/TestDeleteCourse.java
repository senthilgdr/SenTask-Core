package com.sen.test.course;


import com.sen.dao.CourseDetailDAO;
import com.sen.dao.impl.CourseDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;

public class TestDeleteCourse {

	public static void main(String[] args) throws Exception {
	
		CourseDetail cd=new CourseDetail();
		cd.setCourseId(Long.valueOf(38));
		
		CourseDetailDAO dao2 = new CourseDetailDAOJdbcImpl();
		dao2.delete(cd);
		System.out.println("Deleted:"+dao2);

	}

}
