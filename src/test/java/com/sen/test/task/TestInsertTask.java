package com.sen.test.task;

import java.sql.SQLException;

import com.sen.dao.TaskDAO;
import com.sen.dao.TaskDAOJdbcImpl;
import com.sen.dao.UserDetailDAO;
import com.sen.dao.UserDetailDAOJdbcImpl;
import com.sen.view.TaskView;
import com.sen.view.UserDetail;


public class TestInsertTask {

	public static void main(String[] args) throws Exception {

		try{
			
		TaskView cd = new TaskView();
		cd.setName("Create Class");
		cd.setDescription("Creating a Class");
		cd.setStatus("Pending");
		
		UserDetailDAO userDao = new UserDetailDAOJdbcImpl();
		UserDetail ud = userDao.findByOne(3L);
		
		UserDetail ud1 = new UserDetail();
		ud1.setUserId(3L);
		
		cd.setAssignedToUser(ud1);

		TaskDAO dao = new TaskDAOJdbcImpl();
		dao.insert(cd);
		System.out.println("Inserted:" + dao);
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new Exception();
			
		}

	}

}
