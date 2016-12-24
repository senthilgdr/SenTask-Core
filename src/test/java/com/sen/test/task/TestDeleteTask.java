package com.sen.test.task;


import com.sen.dao.TaskDAO;
import com.sen.dao.impl.TaskDAOJdbcImpl;

public class TestDeleteTask {

	public static void main(String[] args) throws Exception {
			
		TaskDAO dao = new TaskDAOJdbcImpl();
		dao.delete(Long.valueOf(9));
		System.out.println("Deleted:"+dao);

	}

}
