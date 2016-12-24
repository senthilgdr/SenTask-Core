package com.sen.dao;

import java.util.List;

import com.sen.view.CourseDetail;

public interface CourseDetailDAO {

	List<CourseDetail> findAll() throws Exception;

	CourseDetail findByOne(Long id) throws Exception;

	void insert(CourseDetail cd) throws Exception;

	void update(CourseDetail cd) throws Exception;

	void delete(CourseDetail courseDetail) throws Exception;

}