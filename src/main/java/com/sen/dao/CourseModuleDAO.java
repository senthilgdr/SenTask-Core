package com.sen.dao;

import java.util.List;

import com.sen.view.CourseModule;

public interface CourseModuleDAO {


	List<CourseModule> findAll() throws Exception;

	CourseModule findByOne(Long id) throws Exception;

	void insert(CourseModule cm) throws Exception;

	void update(CourseModule cm) throws Exception;

	void delete(CourseModule courseModule) throws Exception;

}