package com.saam.mail.implement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.saam.mail.service.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class MailServiceImple implements MailService {
	
	@Autowired JavaMailSender mailSender;
	

	
	//send mail
	@Override
	public void SendMail(String from, String to, String subject, String message) {
		try {
			SimpleMailMessage messages = new SimpleMailMessage();
			
			messages.setFrom(from);
			messages.setTo(to);
			messages.setSubject(subject);
			messages.setText(message);
			
			mailSender.send(messages);
		}catch(Exception e)
		{
			e.getMessage();
		}
	}



	//send mail with attachment
	@Override
	public void sendMailWithAttachement(String from, String to, String subject, String message, String filePath) {
	      
	        Path path = Paths.get(filePath);
	        String fileName = path.getFileName().toString();
		try {
			
			MimeMessage mmessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mmessage, true);
			
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message);
			helper.addAttachment(fileName, new File(filePath) );
			
			mailSender.send(mmessage);
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
	}





	//send mail from form data
	@Override
	public void sendMainByUser(String from, String to, String subject, String message, MultipartFile file)
			throws MessagingException, IOException {
		
	     MimeMessage mimeMessage = mailSender.createMimeMessage();
	     MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(message);
	        helper.setFrom(from);

	       
	        helper.addAttachment(file.getOriginalFilename(), file);

	        mailSender.send(mimeMessage);
		
	}

}
