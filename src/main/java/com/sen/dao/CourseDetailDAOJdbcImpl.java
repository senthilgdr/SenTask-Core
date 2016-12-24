package com.sen.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.util.ConnectionUtil;
import com.sen.view.CourseDetail;

public class CourseDetailDAOJdbcImpl implements CourseDetailDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	public List<CourseDetail> findAll() throws Exception {

		String sql = "select course_id,course_name,description,oprtnl_flag,"
				+ "created_by,created_date,modified_by,modified_date from cm_ma_course where oprtnl_flag='A' ";

		List<CourseDetail> list = jdbcTemplate.query(sql, (rs, rows) -> {
			CourseDetail cd = new CourseDetail();
			cd.setCourseId(rs.getLong("course_id"));
			cd.setCourseName(rs.getString("course_name"));
			cd.setDescription(rs.getString("description"));
			cd.setOprtnlFlag(rs.getString("oprtnl_flag"));
			cd.setCreatedBy(rs.getLong("created_by"));
			cd.setCreatedDate(rs.getDate("created_date"));
			cd.setModifiedBy(rs.getLong("modified_by"));
			cd.setModifiedDate(rs.getDate("modified_date"));
			return cd;

		});
		return list;

	}

	public CourseDetail findByOne(Long id) throws Exception {

		String sql = "select course_id,course_name,description,oprtnl_flag,"
				+ "created_by,created_date,modified_by,modified_date from cm_ma_course where oprtnl_flag='A' and course_id=?";

		CourseDetail courseDetail = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rows) -> {
			CourseDetail cd = new CourseDetail();

			cd.setCourseId(rs.getLong("course_id"));
			cd.setCourseName(rs.getString("course_name"));
			cd.setDescription(rs.getString("description"));
			cd.setOprtnlFlag(rs.getString("oprtnl_flag"));
			cd.setCreatedBy(rs.getLong("created_by"));
			cd.setCreatedDate(rs.getDate("created_date"));
			cd.setModifiedBy(rs.getLong("modified_by"));
			cd.setModifiedDate(rs.getDate("modified_date"));
			return cd;

		});
		return courseDetail;
	}

	public void insert(CourseDetail cd) throws Exception {
		
		String sql="insert into cm_ma_course(course_name,description,oprtnl_flag,created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,?)";
		
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql, new Object[] {cd.getCourseName(), cd.getDescription(),cd.getOprtnlFlag(), cd.getCreatedBy(),currentDate,cd.getCreatedBy(),currentDate });
		System.out.println("No of Rows Inserted:" + rows);
	}

	public void update(CourseDetail cd) throws Exception {
		String sql="update cm_ma_course set course_name=?,description=?,oprtnl_flag=?,modified_by=?,modified_date=? where course_id=?";
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql, new Object[] {cd.getCourseName(), cd.getDescription(),cd.getOprtnlFlag(), cd.getModifiedBy(),currentDate,cd.getCourseId() });
		System.out.println("No of Rows Updated:" + rows);
		
	}

	public void delete(CourseDetail courseDetail) throws Exception {
		
		String sql="update cm_ma_course set oprtnl_flag='I' where course_id = ?";
		int rows = jdbcTemplate.update(sql, new Object[] {courseDetail.getCourseId()});
				
		System.out.println("No of Rows Deleted:" + rows);
		
	}
}
