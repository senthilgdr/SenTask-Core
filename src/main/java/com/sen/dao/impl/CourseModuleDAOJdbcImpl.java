package com.sen.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.dao.CourseModuleDAO;
import com.sen.util.ConnectionUtil;
import com.sen.view.CourseDetail;
import com.sen.view.CourseModule;

public class CourseModuleDAOJdbcImpl implements CourseModuleDAO {

	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	@Override
	public List<CourseModule> findAll() throws Exception {
		String sql = "select c.course_module_id,cc.course_id,c.module_name,c.description,c.rank,c.oprtnl_flag,c.created_by,c.created_date,c.modified_by,c.modified_date from "
				+ "cm_ma_course cc,cm_ma_course_module c where cc.course_id=c.course_id and c.oprtnl_flag='A'";

		List<CourseModule> list = jdbcTemplate.query(sql, (rs, rows) -> {
			CourseModule cm = new CourseModule();
			cm.setCourseModuleId(rs.getLong("course_module_id"));

			CourseDetail cd = new CourseDetail();
			cd.setCourseId(rs.getLong("course_id"));
			cm.setCourseDetail(cd);

			cm.setModuleName(rs.getString("module_name"));
			cm.setDesc(rs.getString("description"));
			cm.setRank(rs.getLong("rank"));
			cm.setOprtnlFlag(rs.getString("oprtnl_flag"));
			cm.setCreatedBy(rs.getLong("created_by"));
			cm.setCreatedDate(rs.getDate("created_date"));
			cm.setModifiedBy(rs.getLong("modified_by"));
			cm.setModifiedDate(rs.getDate("modified_date"));

			return cm;
		});
		return list;

	}

	@Override
	public CourseModule findByOne(Long id) throws Exception {
		String sql = "select c.course_module_id,cc.course_id,c.module_name,c.description,c.rank,c.oprtnl_flag,c.created_by,c.created_date,c.modified_by,"
				+ "c.modified_date from cm_ma_course cc,cm_ma_course_module c where cc.course_id=c.course_id AND c.oprtnl_flag='A' AND c.course_module_id=? ";

		CourseModule courseModule = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, rows) -> {

			CourseModule cm = new CourseModule();
			cm.setCourseModuleId(rs.getLong("course_module_id"));

			CourseDetail cd = new CourseDetail();
			cd.setCourseId(rs.getLong("course_id"));
			cm.setCourseDetail(cd);
			cm.setModuleName(rs.getString("module_name"));
			cm.setDesc(rs.getString("description"));
			cm.setRank(rs.getLong("rank"));
			cm.setOprtnlFlag(rs.getString("oprtnl_flag"));
			cm.setCreatedBy(rs.getLong("created_by"));
			cm.setCreatedDate(rs.getDate("created_date"));
			cm.setModifiedBy(rs.getLong("modified_by"));
			cm.setModifiedDate(rs.getDate("modified_date"));
			return cm;
		});

		return courseModule;

	}

	@Override
	public void insert(CourseModule cm) throws Exception {

		String sql = "INSERT INTO cm_ma_course_module(COURSE_ID,MODULE_NAME,DESCRIPTION,RANK,OPRTNL_FLAG,CREATED_BY,created_date,"
				+ " MODIFIED_BY, modified_date) VALUES (?,?,?,?,?,?,?,?,?)";
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql,
				new Object[] { cm.getCourseDetail().getCourseId(), cm.getModuleName(), cm.getDesc(), cm.getRank(),
						cm.getOprtnlFlag(), cm.getCreatedBy(), currentDate, cm.getCreatedBy(), currentDate });
		System.out.println("No of Rows Inserted:" + rows);

	}

	@Override
	public void update(CourseModule cm) throws Exception {

		String sql = "update cm_ma_course_module set course_id=?,module_name=?,description=?,rank=?,oprtnl_flag=?,"
				+ "modified_by=?,modified_date=? where course_module_id=?";

		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql,
				new Object[] { cm.getCourseDetail().getCourseId(), cm.getModuleName(), cm.getDesc(), cm.getRank(),
						cm.getOprtnlFlag(), cm.getModifiedBy(), currentDate, cm.getCourseModuleId() });
		System.out.println("No of Rows Updated:" + rows);

	}

	@Override
	public void delete(CourseModule courseModule) throws Exception {
		String sql="update cm_ma_course_module set oprtnl_flag='I' , modified_by = ?, modified_date = ? where course_module_id = ?";
		
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows=jdbcTemplate.update(sql,new Object[] {courseModule.getModifiedBy(),currentDate,courseModule.getCourseModuleId() });
		System.out.println("No of Rows Deleted:" + rows);
		
	}	
}
