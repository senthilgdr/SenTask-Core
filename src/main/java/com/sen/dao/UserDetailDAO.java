package com.sen.dao;

import java.util.List;

import com.sen.view.UserDetail;


public interface UserDetailDAO {

	List<UserDetail> findAll() throws Exception;

	UserDetail isValidLogin(String userName, String passWord) throws Exception;

	boolean isValidLogin1(String userName, String passWord) throws Exception;

	UserDetail findByOne(Long id) throws Exception;

	void insert(UserDetail ud) throws Exception;

	void update(UserDetail ud) throws Exception;

	void delete(UserDetail userDetail) throws Exception;
	
	void activateAccount(UserDetail userDetail)throws Exception;
	
	void disableAccount(UserDetail userDetail) throws Exception;
	
	UserDetail getPassword(String emailId) throws Exception;
	
	boolean changePassword(UserDetail userDetail, String oldPassword, String newPassword) throws Exception;
	
	UserDetail findName(String name) throws Exception;
	
	UserDetail findByEmailId(String emailId) throws Exception;

}