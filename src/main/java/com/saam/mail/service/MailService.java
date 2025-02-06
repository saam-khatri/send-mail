package com.saam.mail.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.MessagingException;

public interface MailService {

	public void SendMail(String from, String to, String subject, String message);
	
	public void sendMailWithAttachement(String from, String to, String subject, String message, String filePath);
	
	public void sendMainByUser(String from, String to, String subject, String message, MultipartFile file) throws MessagingException, IOException ;
}
