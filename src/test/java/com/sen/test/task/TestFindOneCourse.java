package com.sen.test.task;

import com.sen.dao.TaskDAO;
import com.sen.dao.impl.TaskDAOJdbcImpl;
import com.sen.view.TaskView;


public class TestFindOneCourse {

	public static void main(String[] args) throws Exception {
		TaskDAO taskDAO=new TaskDAOJdbcImpl();
		TaskView tv = taskDAO.findByOne(Long.valueOf(3));
		System.out.println("FindOne:"+tv);
		
	}

}
