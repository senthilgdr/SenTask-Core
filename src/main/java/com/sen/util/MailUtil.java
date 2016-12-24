package com.sen.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/* 1 method */
public class MailUtil {

	@SuppressWarnings("deprecation")
	public static void sendMail(String emailId, String subject, String content) throws Exception {

		Email email = new SimpleEmail();

		email.setSmtpPort(587);

		//email.setAuthenticator(new DefaultAuthenticator("spinsenthil@gmail.com", "jalbcbrbobzxfgea"));

		email.setDebug(false);

		email.setHostName("smtp.gmail.com");
		email.setFrom("spinsenthil@gmail.com");

		email.setSubject(subject); // change here

		email.setMsg(content);

		email.addTo(emailId); // correct

		email.setTLS(true);
		email.send();
	}
}
