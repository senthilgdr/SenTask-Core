package com.sen.view;

import java.util.Date;

public class CourseModule {
	private Long courseModuleId;
	private CourseDetail courseDetail;
	private String moduleName;
	private String desc;
	private Long rank;
	private String oprtnlFlag="A";
	private Long createdBy;
	private Date createdDate;
	private Long modifiedBy;
	private Date modifiedDate;
	public Long getCourseModuleId() {
		return courseModuleId;
	}
	public void setCourseModuleId(Long courseModuleId) {
		this.courseModuleId = courseModuleId;
	}
	public CourseDetail getCourseDetail() {
		return courseDetail;
	}
	public void setCourseDetail(CourseDetail courseDetail) {
		this.courseDetail = courseDetail;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Long getRank() {
		return rank;
	}
	public void setRank(Long rank) {
		this.rank = rank;
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
	@Override
	public String toString() {
		return "CourseModule [courseModuleId=" + courseModuleId + ", courseDetail=" + courseDetail + ", moduleName="
				+ moduleName + ", desc=" + desc + ", rank=" + rank + ", oprtnlFlag=" + oprtnlFlag + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", modifiedBy=" + modifiedBy + ", modifiedDate="
				+ modifiedDate + "]";
	}
				
	
}
