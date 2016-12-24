package com.sen.view;

import java.time.LocalDate;

public class UserCourse {

	private Long id;
	private CourseDetail course;
	private UserDetail userDetail;
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private LocalDate startDate;
	private LocalDate completionDate;
	private String status;
	private String oprtnlFlag;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CourseDetail getCourse() {
		return course;
	}
	public void setCourse(CourseDetail course) {
		this.course = course;
	}
	public UserDetail getUserDetail() {
		return userDetail;
	}
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	public String getOprtnlFlag() {
		return oprtnlFlag;
	}
	public void setOprtnlFlag(String oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
	}
	@Override
	public String toString() {
		return "UserCourse [id=" + id + ", course=" + course + ", userDetail=" + userDetail + ", startDate=" + startDate
				+ ", completionDate=" + completionDate + ", status=" + status + ", oprtnlFlag=" + oprtnlFlag + "]";
	}
	
	
}