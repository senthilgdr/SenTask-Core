package com.sen.test.task;

import java.util.List;

import com.sen.dao.TaskDAO;
import com.sen.dao.impl.TaskDAOJdbcImpl;
import com.sen.view.TaskView;

public class TestSelectTask {

	public static void main(String[] args) throws Exception {
		/*TaskDAO taskDAO=new TaskDAOImpl();*/
		TaskDAO taskDAO=new TaskDAOJdbcImpl();
		List<TaskView> list = taskDAO.findAll();
		for (TaskView cd : list) {
			System.out.println(cd);
		}
	}

}
