package com.sen.dao;

import java.util.List;

import com.sen.view.UserType;

public interface UserTypeDAO {

	List<UserType> findAll() throws Exception;

	UserType findByOne(Long id) throws Exception;

	void insert(UserType userType) throws Exception;

	void update(UserType userType) throws Exception;

	void delete(UserType userType) throws Exception;

}