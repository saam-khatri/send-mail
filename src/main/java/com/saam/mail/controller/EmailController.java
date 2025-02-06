package com.saam.mail.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.saam.mail.service.MailService;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {

    @Autowired
    MailService mailService;
    
    // Send a simple email
    @GetMapping("/send-mail")
    public String sendMail() {
        mailService.SendMail(
		        "yourEmail.com", 
		        "yourEmail.com", 
		        "hello",              
		        "hello saam ma testing gardai xu ahile lai" 
		);
		return "Success: Email sent!";
    }

    // Send email with attachment
    @GetMapping("/send-mail-with-attachment")
    public String sendMailWithAttachment() {
        mailService.sendMailWithAttachement(
		        "yourEmail.com", 
		        "yourEmail.com", 
		        "hello",               
		        "hello saam ma testing gardai xu ahile lai", 
		        "C:/Users/texto/OneDrive/Pictures/Screenshots/one.png" 
		);
		return "Success: Email with attachment sent!";
    }

    // Show email form for HTML-based emails
    @GetMapping("/send-email-html")
    public String getEmailForm() {
        return "emailForm.jsp"; 
    }

    // Handle form submission to send HTML emails
    @PostMapping("/send-email-html")
    public String sendMailHtml(
            @RequestParam("from") String from,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message,
            @RequestParam("file") MultipartFile file) throws MessagingException {
        
        String to = "yourEmail.com";
        
        try {
   
            mailService.sendMainByUser(from, to, subject, message, file);
            return "Success: HTML email sent!";
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
            return "Error: Could not send HTML email.";
        }
    }
}
