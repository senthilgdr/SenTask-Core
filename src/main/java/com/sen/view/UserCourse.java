package com.sen.view;

public class UserCourse {

	private Long id;
	private CourseDetail course;
	private UserDetail userDetail;
	private String oprtnlFlag="A";
	
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
		return "UserCourse [id=" + id + ", course=" + course + ", userDetail=" + userDetail + ", oprtnlFlag="
				+ oprtnlFlag + "]";
	}
	
	
}