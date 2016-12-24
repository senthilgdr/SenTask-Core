package com.sen.util;

import com.sen.dao.impl.UserDetailDAOJdbcImpl;
import com.sen.view.UserCourse;
import com.sen.view.UserDetail;

/* 3 methods in mailmanager*/
public class CourseMailManager {
	
	public static void sendCourseEnrollEmail(UserCourse uc) throws Exception {

		String subject = "Reg: Welcome to LearningTask App";

		StringBuilder message = new StringBuilder();

		Long userId = uc.getUserDetail().getUserId();
		UserDetail userDetail = new UserDetailDAOJdbcImpl().findByOne(userId);
		
		message.append("Dear " + userDetail.getName() + ",\n");
		message.append("Successfully you have enrolled "+ uc.getCourse().getCourseName()+ "  course in LearningTask Website.");
		message.append("Regards ");
		message.append("LearningTask Support Team");

		System.out.println(message);
		//MailUtil.sendMail(uc.getUserDetail().getEmailId(), subject, message.toString());
		System.out.println("Mail sent!");

	}

	public static void disableEnroll(UserCourse uc, String courseName) throws Exception {

		String subject = "Reg: Welcome to LearningTask App";

		StringBuilder message = new StringBuilder();

		
		Long userId = uc.getUserDetail().getUserId();
		UserDetail userDetail = new UserDetailDAOJdbcImpl().findByOne(userId);
		message.append("Dear " + userDetail.getName() + ",\n");
		message.append("Successfully you are UnEnrolled " +courseName+" to LearningTask Website.");
		message.append("Regards ");
		message.append("LearningTask Support Team");

		System.out.println("Unenroll :" + message);
		
		String emailId = userDetail.getEmailId();
		//MailUtil.sendMail(emailId, subject, message.toString()); //After checking sysout , call mail
		System.out.println("Mail sent!");
		
	}
/*	public static void disableEnroll(UserCourse uc, String courseName) throws Exception {

		String subject = "Reg: Welcome to LearningTask App";

		StringBuilder message = new StringBuilder();
		
		message.append("Dear " + uc.getUserDetail().getName() + ",\n");
		message.append("Successfully you are Selected " +courseName+" to LearningTask Website.");
		message.append("Regards ");
		message.append("LearningTask Support Team");

		
		String emailId = uc.getUserDetail().getEmailId(); //using the id, get MailId

		MailUtil.sendMail(emailId, subject, message.toString());
		System.out.println("Mail sent!");
		
	}*/
	
}
