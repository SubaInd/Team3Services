package com.qbthon.emailservice.service;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.qbthon.emailservice.model.Email;

@Service("emailService")
public class EmailService 
{
    @Autowired
    private JavaMailSender mailSender;
      
    
  
    /**
     * This method will send compose and send the message 
     * @throws MessagingException 
     * */
    public void sendMail(List<String> to, String subject, String body, File[] attachments) throws MessagingException 
    {
       
        MimeMessage message = mailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
       
        helper.setSubject(subject);
        helper.setText(body,true);

        for (File file : attachments) {
			FileSystemResource fr = new FileSystemResource(file);
			helper.addAttachment(file.getName(), fr);
		}
        for(int i=0;i<to.size();i++) {
        	 helper.setTo(to.get(i));
        	 mailSender.send(message);
        }
       
        
       
    }
    
    public void sendMail(Email email) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	for(int i=0;i<email.getTo().size();i++) {
    		message.setTo(email.getTo().get(i));
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            mailSender.send(message);
    	}
    	  
    }
   
}