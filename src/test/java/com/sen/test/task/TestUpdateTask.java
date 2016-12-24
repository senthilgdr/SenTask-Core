package com.sen.test.task;

import com.sen.dao.TaskDAO;
import com.sen.dao.impl.TaskDAOJdbcImpl;
import com.sen.view.TaskView;
import com.sen.view.UserDetail;

public class TestUpdateTask {

	public static void main(String[] args) throws Exception {
		
		TaskView tv = new TaskDAOJdbcImpl().findByOne(Long.valueOf(3));
		tv.setName("Creating a Java Class");
		tv.setStatus("Completed");
		
		UserDetail ud1 = new UserDetail();
		ud1.setUserId(6L);
		
		tv.setAssignedToUser(ud1);
		
		TaskDAO dao = new TaskDAOJdbcImpl();
		dao.update(tv);
		System.out.println("Updated:" + tv);

	}

}
