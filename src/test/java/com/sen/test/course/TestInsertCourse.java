package com.sen.test.course;

import java.sql.SQLException;

import com.sen.dao.CourseDetailDAO;
import com.sen.dao.CourseDetailDAOJdbcImpl;
import com.sen.view.CourseDetail;

public class TestInsertCourse {

	public static void main(String[] args) throws Exception {

		try{
			
		CourseDetail cd = new CourseDetail();
		cd.setCourseName("test1");
		cd.setDescription("EE");
		
		/*UserDetail userDetail=new UserDetail();
		cd.setCreatedBy(userDetail.getUserId());*/
		cd.setCreatedBy(Long.valueOf(1));

		CourseDetailDAO dao = new CourseDetailDAOJdbcImpl();
		dao.insert(cd);
		System.out.println("Inserted:" + dao);
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new Exception();
			
		}

	}

}
