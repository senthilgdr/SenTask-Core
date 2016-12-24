package com.sen.view;

import java.util.Date;

public class CourseDetail {

	private Long courseId;
	private String courseName;
	private String description;
	private String oprtnlFlag="A";
	private Long createdBy;
	private Date createdDate;
	private Long modifiedBy;
	private Date modifiedDate;
	
	@Override
	public String toString() {
		return "CourseDetail [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", oprtnlFlag=" + oprtnlFlag + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", modifiedBy=" + modifiedBy + ", modifiedDate=" + modifiedDate + "]";
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOprtnlFlag() {
		return oprtnlFlag;
	}
	public void setOprtnlFlag(String oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public static void main(String[] args) {
		
	}

}
