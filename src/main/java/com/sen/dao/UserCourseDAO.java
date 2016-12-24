package com.sen.dao;

import java.util.List;

import com.sen.view.UserCourse;

public interface UserCourseDAO {

	void courseEnroll(UserCourse userCourse) throws Exception;

	UserCourse findOne(Long userCourseId) throws Exception;

	void disableEnrollCourse(Long userCourseId) throws Exception;

	List<UserCourse> findByUserId(Long userId) throws Exception;

	List<UserCourse> findByStudent(Long courseId) throws Exception;

}