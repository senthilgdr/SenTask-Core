package com.sen.util;

import com.sen.view.UserDetail;

/* 3 methods in mailmanager*/
public class UserMailManager {
	
	public static void sendNewRegistrationEmail(UserDetail ud) throws Exception {

		String subject = "Reg: Welcome to SenTask App";

		StringBuilder message = new StringBuilder();

		message.append("Dear" + ud.getName() + ",\n");
		message.append("Successfully you are registered to SenTask Website.");
		message.append("Regards ");
		message.append("SenTask Support Team");

		MailUtil.sendMail(ud.getEmailId(), subject, message.toString());
		System.out.println("Mail sent!");

	}

	public static void sendPassword(String toEmailId, String name, String password) throws Exception {

		String subject = "Reg:Your Forgot Password";

		StringBuilder message = new StringBuilder();

		message.append("Dear " + name + "...\n");
		message.append("Your password here (" + password + ")\n"); 
																
		message.append("Regards \n");
		message.append("SenTask Support Team");

		MailUtil.sendMail(toEmailId, subject, message.toString());

	}

	public static void changePassword(UserDetail userDeatil, String newPassword) throws Exception {

		String subject = "Reg:Your New Password";
		StringBuilder message = new StringBuilder();

		message.append("Dear " + userDeatil.getName() + "...\n");
		message.append("Your new password here (" + newPassword + ")\n"); // send
																			// password
		message.append("Regards \n");
		message.append("SenTask Support Team");

		MailUtil.sendMail(userDeatil.getEmailId(), subject, message.toString());
		System.out.println("Mail sent!");
	}



}
