package com.sen.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.dao.UserCourseDAO;
import com.sen.util.ConnectionUtil;
import com.sen.view.CourseDetail;
import com.sen.view.UserCourse;
import com.sen.view.UserDetail;


public class UserCourseDAOJdbcImpl implements UserCourseDAO {
	
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public void courseEnroll(UserCourse userCourse) throws Exception {
		
		String sql="insert into cm_ma_user_course(user_cid,course_cid,oprtnl_flag) values(?,?,?)";
		int rows = jdbcTemplate.update(sql, new Object[] { userCourse.getUserDetail().getUserId(), userCourse.getCourse().getCourseId(),userCourse.getOprtnlFlag()});
		System.out.println("No of Rows Inserted:" + rows);
				
	}
	

	public UserCourse findOne(Long userCourseId) throws Exception{
		
		String sql="select c.course_name , uc.user_cid, uc.user_course_id, uc.course_cid, uc.oprtnl_flag from cm_ma_course c, cm_ma_user_course uc "
				+ "  where c.course_id = uc.course_cid and uc.user_course_id=? and uc.oprtnl_flag='A'";
		
		
		UserCourse userCourse =jdbcTemplate.queryForObject(sql,new Object[]{userCourseId}, (rs,rows) -> {
			UserCourse uc=new UserCourse();
			uc.setId(rs.getLong("user_course_id"));
			
			CourseDetail c = new CourseDetail();
			c.setCourseId(rs.getLong("course_cid"));
			c.setCourseName(rs.getString("course_name"));
			
			uc.setCourse(c);
			uc.setOprtnlFlag(rs.getString("oprtnl_flag"));
			
			Long userId = rs.getLong("user_cid");
			
			UserDetail userDetail = new UserDetail();
			userDetail.setUserId(userId); //only set id here.
			
			uc.setUserDetail(userDetail);
			return uc;

		});
		return userCourse;
	}
		

	public void disableEnrollCourse (UserCourse uc ) throws Exception {
		
					
			String sql="update cm_ma_user_course set oprtnl_flag='I' where user_course_id= ? and oprtnl_flag='A'";
			int rows = jdbcTemplate.update(sql, new Object[] { uc.getId() });
			System.out.println("No of Rows Disable:" + rows);	
		
	}
	
	public List<UserCourse> findByUserId(Long userId) throws Exception{
		String sql="select c.course_name ,uc.user_course_id, uc.course_cid, uc.oprtnl_flag from cm_ma_course c, cm_ma_user_course uc "
						+ "  where c.course_id = uc.course_cid and uc.user_cid=? and uc.oprtnl_flag='A'";
		
		
		List<UserCourse> userCourse = jdbcTemplate.query(sql,new Object[]{userId}, (rs,rows) -> {
			
		UserCourse uc=new UserCourse();
		uc.setId(rs.getLong("user_course_id"));
		
		CourseDetail c = new CourseDetail();
		c.setCourseId(rs.getLong("course_cid"));
		c.setCourseName(rs.getString("course_name"));
		
		uc.setCourse(c);
		uc.setOprtnlFlag(rs.getString("oprtnl_flag"));
		
		return uc;
	});
	return userCourse;
	}

	


	public List<UserCourse> findByStudent(Long courseId) throws Exception {
		
	String sql="SELECT uu.name ,uc.user_course_id, uc.user_cid, uc.oprtnl_flag FROM "
			+ "user_account uu, cm_ma_user_course uc WHERE"
			+ " uu.user_sid = uc.user_cid AND uc.course_cid=? AND uc.oprtnl_flag='A'";
	
		
		List<UserCourse> list= jdbcTemplate.query(sql,new Object[]{courseId}, (rs,rows) -> {
		
				
			UserCourse uc=new UserCourse();
				uc.setId(rs.getLong("user_course_id"));
												
				UserDetail ud=new UserDetail();
				ud.setUserId(rs.getLong("user_sid"));
				ud.setName(rs.getString("name"));				
				uc.setUserDetail(ud);
				
				uc.setOprtnlFlag(rs.getString("oprtnl_flag"));
				
			return uc;
		});
		return list;

	}

}