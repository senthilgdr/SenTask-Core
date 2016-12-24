package com.sen.dao;

import java.util.List;

import com.sen.view.TaskView;

public interface TaskDAO {

	List<TaskView> findAll() throws Exception;

	TaskView findByOne(Long id) throws Exception;

	void insert(TaskView tv) throws Exception;

	void update(TaskView tv) throws Exception;

	void delete(Long id) throws Exception;

}