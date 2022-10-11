package com.team.prj.join.service;

import javax.mail.internet.MimeMessage;

public interface MailServiceInter {
	
	
	String sendSimpleMessage(String to) throws Exception;

	MimeMessage createMessage(String to) throws Exception;
	
	String createKey();
}
