package com.sen.view;

import java.util.Date;

public class TaskView {
	
	private Long id;
	private String name;	
	private String description;
	private String status;
	private Date createdDate;
	private Date modifiedDate;
	private UserDetail assignedToUser;
	
	@Override
	public String toString() {
		return "TaskView [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", assignedToUser="
				+ assignedToUser + "]";
	}	
	
	public UserDetail getAssignedToUser() {
		return assignedToUser;
	}
	public void setAssignedToUser(UserDetail assignedToUser) {
		this.assignedToUser = assignedToUser;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
