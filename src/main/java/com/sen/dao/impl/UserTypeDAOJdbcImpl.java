package com.sen.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.dao.UserTypeDAO;
import com.sen.util.ConnectionUtil;
import com.sen.view.UserType;



public class UserTypeDAOJdbcImpl implements UserTypeDAO {
	
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<UserType> findAll() throws Exception {

		String sql="select id,user_type,oprtnl_flag from user_type where oprtnl_flag='A'";
		
		List<UserType> list =jdbcTemplate.query(sql, (rs,rows) -> {
			UserType uv = new UserType();
			uv.setUserTypeId(rs.getLong("id"));
			uv.setUserType(rs.getString("user_type"));
			uv.setOprtnlFlag(rs.getString("oprtnl_flag"));
			return uv;
		});
		return list;

	}

	public UserType findByOne(Long id) throws Exception {
		
		
		String sql="select id,user_type,oprtnl_flag from user_type where oprtnl_flag='A' and id=?";
		
		UserType userType = jdbcTemplate.queryForObject(sql,new Object[]{id}, (rs,rows) -> {
			
			UserType uv=new UserType();
			uv = new UserType();
			uv.setUserTypeId(rs.getLong("id"));
			uv.setUserType(rs.getString("user_type"));
			uv.setOprtnlFlag(rs.getString("oprtnl_flag"));
			return uv;
		});
		
		return userType;
	}

	public void insert(UserType uv) throws Exception {
		
		String sql = "insert into  user_type(id,user_type,oprtnl_flag) values(?,?,?)";
		int rows=jdbcTemplate.update(sql,new Object[] {uv.getUserTypeId(),uv.getUserType(),uv.getOprtnlFlag()});
		System.out.println("No of Rows Inserted:" + rows);
	}

	public void update(UserType uv) throws Exception {
		
		String sql ="update user_type set user_type=?,oprtnl_flag=? where id=?";
		int rows=jdbcTemplate.update(sql,new Object[] {uv.getUserType(),uv.getOprtnlFlag(),uv.getUserTypeId()});
		System.out.println("No of Rows Updated:" + rows);
	}

	public void delete(UserType userType) throws Exception {
		
		String sql="update user_type set oprtnl_flag='I' where id = ?";
		int rows=jdbcTemplate.update(sql,new Object[] {userType.getUserTypeId()});
		System.out.println("No of Rows Deleted:" + rows);
		
	}


}
