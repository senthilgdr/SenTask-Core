package com.sen.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.sen.util.ConnectionUtil;
import com.sen.view.TaskView;
import com.sen.view.UserDetail;

public class TaskDAOJdbcImpl implements TaskDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.TaskDAO#findAll()
	 */
	private JdbcTemplate jdbcTemplate = ConnectionUtil.getJdbcTemplate();

	@SuppressWarnings("unchecked")
	public List<TaskView> findAll() throws Exception {

		String sql = "select t.id,t.name,t.description,t.status,t.created_date,t.modified_date,t.assigned_to,u.id as user_id,u.name as username from task t,user_account u where t.assigned_to=u.id";

		List<TaskView> list = jdbcTemplate.query(sql, (rs,rows) -> {
			
			TaskView tv = new TaskView();
			tv.setId(rs.getLong("id"));
			tv.setName(rs.getString("name"));
			tv.setDescription(rs.getString("description"));
			tv.setStatus(rs.getString("status"));
			tv.setCreatedDate(rs.getDate("created_date"));
			tv.setModifiedDate(rs.getDate("modified_date"));

			UserDetail u = new UserDetail();
			u.setUserId(rs.getLong("user_id"));
			u.setName(rs.getString("username"));

			tv.setAssignedToUser(u);
			return tv;

		});
		return list;

		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.TaskDAO#findByOne(java.lang.Long)
	 */
	public TaskView findByOne(Long id) throws Exception {
		
		String sql="select t.id,t.name,t.description,t.status,t.created_date,t.modified_date,t.assigned_to,u.id as user_id, u.name as username from task t,user_account u where t.assigned_to=u.id AND t.id=?";
		
		TaskView taskDetail = jdbcTemplate.queryForObject(sql,new Object[]{id}, (rs,rows) -> {
			TaskView tv = new TaskView();
			tv.setId(rs.getLong("id"));
			tv.setName(rs.getString("name"));
			tv.setDescription(rs.getString("description"));
			tv.setStatus(rs.getString("status"));
			tv.setCreatedDate(rs.getDate("created_date"));
			tv.setModifiedDate(rs.getDate("modified_date"));

			UserDetail u = new UserDetail();
			u.setUserId(rs.getLong("user_id"));
			u.setName(rs.getString("username"));

			tv.setAssignedToUser(u);
			return tv;

		});
		return taskDetail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.TaskDAO#insert(com.sen.view.TaskView)
	 */
	public void insert(TaskView tv) throws Exception {

		String sql = "insert into task(name,description,status,created_date,modified_date,assigned_to) values(?,?,?,?,?,?)";
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql, new Object[] { tv.getName(), tv.getDescription(), "Pending", currentDate,
				currentDate, tv.getAssignedToUser().getUserId() });
		System.out.println("No of Rows Inserted:" + rows);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.TaskDAO#update(com.sen.view.TaskView)
	 */
	public void update(TaskView tv) throws Exception {
		String sql = "update task set name=?,description=?,status=?,modified_date=?,assigned_to=? where id=?";
		java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
		int rows = jdbcTemplate.update(sql, new Object[] { tv.getName(), tv.getDescription(), tv.getStatus(),
				currentDate, tv.getAssignedToUser().getUserId(), tv.getId() });
		System.out.println("No of Rows Updated:" + rows);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sen.dao.TaskDAO#delete(java.lang.Long)
	 */
	public void delete(Long id) throws Exception {

		String query = "delete from task where id=?";
		int rows = jdbcTemplate.update(query, new Object[] { id });
		System.out.println("No of Rows Deleted:" + rows);

	}
}
