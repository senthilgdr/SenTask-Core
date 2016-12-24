package com.sen.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.dao.UserDetailDAO;
import com.sen.util.ConnectionUtil;
import com.sen.view.UserDetail;
import com.sen.view.UserType;

public class UserDetailDAOJdbcImpl implements UserDetailDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#findAll()
	 * 
	 */
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<UserDetail> findAll() throws Exception {

		String sql = "select uu.id,uu.user_type_sid,u.user_type,uu.name,uu.username,uu.password,uu.email_id,uu.oprtnl_flag,uu.created_by from user_account uu,user_type u "
				+ "  where uu.user_type_sid=u.id and uu.oprtnl_flag='A'";

		List<UserDetail> list = jdbcTemplate.query(sql, (rs, rows) -> {
			UserDetail ud = new UserDetail();
			ud.setUserId(rs.getLong("id"));
			ud.setName(rs.getString("name"));
			ud.setUserName(rs.getString("username"));
			ud.setPassWord(rs.getString("password"));
			ud.setEmailId(rs.getString("email_id"));
			ud.setOprnlFlag(rs.getString("oprtnl_flag"));

			UserType uv = new UserType();
			uv.setUserTypeId(rs.getLong("id"));
			uv.setUserType(rs.getString("user_type"));
			ud.setUserType(uv);
			ud.setCreatedBy(rs.getLong("created_by"));

			return ud;
		});

		return list;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#isValidLogin(java.lang.String,
	 * java.lang.String)
	 */
	public UserDetail isValidLogin(String userName, String passWord) throws Exception {

		String sql = "select uu.id,uu.user_type_sid,u.user_type,uu.name,uu.username,uu.password,uu.email_id,uu.oprtnl_flag,uu.created_by from user_account uu,user_type u "
				+ "  where uu.user_type_sid=u.id and username=? and password=? and uu.oprtnl_flag='A'";

		UserDetail userDeatil = jdbcTemplate.queryForObject(sql,new Object[]{ userName, passWord }, (rs,rows) -> {
			
			UserDetail ud = new UserDetail();
			ud.setUserId(rs.getLong("id"));
			ud.setName(rs.getString("name"));
			ud.setUserName(rs.getString("username"));
			// ud.setPassWord(rs.getString("password"));
			ud.setEmailId(rs.getString("email_id"));
			ud.setOprnlFlag(rs.getString("oprtnl_flag"));

			UserType uv = new UserType();
			uv.setUserTypeId(rs.getLong("id"));
			uv.setUserType(rs.getString("user_type"));
			ud.setUserType(uv);
			ud.setCreatedBy(rs.getLong("created_by"));
			return ud;

		});

		return userDeatil;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#isValidLogin1(java.lang.String,
	 * java.lang.String)
	 */
	public boolean isValidLogin1(String userName, String passWord) throws Exception {

		boolean isvlaid = false;
		String sql = "select count(*) from user_account where username=? and password=? and oprtnl_flag='A'";
		Integer count = jdbcTemplate.queryForObject(sql, new Object[] { userName, passWord }, Integer.class);
		if (count > 0) {
			isvlaid = true;
		}

		return isvlaid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#findByOne(java.lang.Long)
	 */
	public UserDetail findByOne(Long id) throws Exception {

		String sql = "select uu.id,u.id,u.user_type,uu.name,uu.username,uu.password,uu.email_id,uu.oprtnl_flag,"
				+ "uu.created_by from user_account uu,user_type u where uu.user_type_sid=u.id and uu.id=? and uu.oprtnl_flag='A'";

			UserDetail userDeatil=jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rows) -> {
			UserDetail ud = new UserDetail();
			ud.setUserId(rs.getLong("id"));
			ud.setName(rs.getString("name"));
			ud.setUserName(rs.getString("username"));
			ud.setPassWord(rs.getString("password"));
			ud.setEmailId(rs.getString("email_id"));
			ud.setOprnlFlag(rs.getString("oprtnl_flag"));

			UserType uv = new UserType();
			uv.setUserTypeId(rs.getLong("id"));
			uv.setUserType(rs.getString("user_type"));
			ud.setUserType(uv);
			ud.setCreatedBy(rs.getLong("created_by"));
			return ud;
		});

		return userDeatil;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#insert(com.sen.view.UserDetail)
	 */
	public void insert(UserDetail ud) throws Exception {

		String sql = "insert into user_account(user_type_sid,name,username,password,email_id,oprtnl_flag,created_by) values(?,?,?,?,?,?,?)";
		int rows = jdbcTemplate.update(sql, new Object[] { ud.getUserType().getUserTypeId(), ud.getName(),
				ud.getUserName(), ud.getPassWord(), ud.getEmailId(), "A" ,ud.getCreatedBy() });
		System.out.println("No of Rows Inserted:" + rows);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#update(com.sen.view.UserDetail)
	 */
	public void update(UserDetail ud) throws Exception {
		String sql = "update user_account set user_type_sid=?,name=?,username=?,password=?,email_id=?,oprtnl_flag=?,created_by=? where id=?";
		int rows = jdbcTemplate.update(sql,
				new Object[] { ud.getUserType().getUserTypeId(), ud.getName(), ud.getUserName(), ud.getPassWord(),
						ud.getEmailId(), ud.getOprnlFlag(), ud.getCreatedBy(), ud.getUserId() });
		System.out.println("No of Rows Updated:" + rows);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.UserDetail#delete(com.sen.view.UserDetail)
	 */
	public void delete(UserDetail userDetail) throws Exception {
		String sql = "update user_account set oprtnl_flag='I' where id= ?";
		int rows = jdbcTemplate.update(sql, new Object[] { userDetail.getUserId() });
		System.out.println("No of Rows Deleted:" + rows);
	}

	public void activateAccount(UserDetail userDetail) throws Exception {

		String sql = "update user_account set oprtnl_flag='A' where user_sid= ? and oprtnl_flag='I'";
		int rows = jdbcTemplate.update(sql, new Object[] { userDetail.getUserId() });
		System.out.println("No of Rows Activated:" + rows);

	}

	public void disableAccount(UserDetail userDetail) throws Exception {

		String sql = "update user_account set oprtnl_flag='I' where user_sid= ? and oprtnl_flag='A'";
		int rows = jdbcTemplate.update(sql, new Object[] { userDetail.getUserId() });
		System.out.println("No of Rows Disable:" + rows);

	}
	public UserDetail getPassword(String emailId) throws Exception {
		String sql = "select password,name from user_account where email_id=? ";
		UserDetail userDetail =jdbcTemplate.queryForObject(sql, new Object[] { emailId }, (rs, rows) -> {
			UserDetail ud = new UserDetail();
			ud.setPassWord(rs.getString("password"));
			ud.setName(rs.getString("name"));
			return ud;
		});

		return userDetail;
	}


	public boolean changePassword(UserDetail userDetail, String oldPassword, String newPassword) throws Exception {
		boolean rowsAffected = false;
		String sql = "update user_account set password=?, MODIFIED_DATE= now() where username=? and password= ?";
		int rows = jdbcTemplate.update(sql, new Object[] { newPassword, userDetail.getUserName(), oldPassword });

		if (rows >= 1) {
			rowsAffected = true;
		}

		return rowsAffected;

	}

	public UserDetail findName(String name) throws Exception {

		String sql = "select uu.user_sid,u.user_type,uu.name,uu.username,uu.email_id,uu.oprtnl_flag,"
				+ "uu.created_by from user_account uu,user_type u where uu.user_type_sid=u.user_type_sid and uu.name=? ";
		UserDetail userDetail = jdbcTemplate.queryForObject(sql, new Object[] { name }, (rs, rows) -> {

			UserDetail ud = new UserDetail();

			ud.setUserId(rs.getLong("user_sid"));
			ud.setName(rs.getString("name"));
			ud.setUserName(rs.getString("username"));
			ud.setEmailId(rs.getString("email_id"));
			ud.setOprnlFlag(rs.getString("oprtnl_flag"));

			UserType uv = new UserType();
			uv.setUserType(rs.getString("user_type"));
			ud.setUserType(uv);
			ud.setCreatedBy(rs.getLong("created_by"));
			return ud;
		});

		return userDetail;

	}

	public UserDetail findByEmailId(String emailId) throws Exception {

		String sql = "select uu.user_sid,uu.name,uu.username,uu.password,uu.email_id,uu.oprtnl_flag"
				+ " from user_account uu where uu.email_id=? ";
		UserDetail userDetail = jdbcTemplate.queryForObject(sql, new Object[] { emailId }, (rs, rows) -> {

			UserDetail ud = new UserDetail();
			ud.setUserId(rs.getLong("user_sid"));
			ud.setName(rs.getString("name"));
			ud.setUserName(rs.getString("username"));
			ud.setPassWord(rs.getString("password"));
			ud.setEmailId(rs.getString("email_id"));
			ud.setOprnlFlag(rs.getString("oprtnl_flag"));

			return ud;
		});
		return userDetail;
	}

}
