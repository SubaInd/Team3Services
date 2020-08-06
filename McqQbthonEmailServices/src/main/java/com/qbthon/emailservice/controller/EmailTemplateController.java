package com.qbthon.emailservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.qbthon.emailservice.model.Email;
import com.qbthon.emailservice.service.EmailTemplateService;


@CrossOrigin
@Controller
public class EmailTemplateController {

	@Autowired
	EmailTemplateService emailTemplateService;
	
	@GetMapping("/getAllTemplates")
		public ResponseEntity<Object> getAllTemplates(){
		try {
			return new ResponseEntity<>(emailTemplateService.getAllTemplates(),HttpStatus.OK);
		}
		
		catch(Exception ex) {
			return new ResponseEntity<>("Couldnt get the email templates",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/createTemplate/")
	public ResponseEntity<Object> createEvent(@ModelAttribute Email email) {
		
		try {
				
			String message =emailTemplateService.createEmailTemplate(email);
			
			
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception ex){
			
			return new ResponseEntity<>("Cant create Tempalte "+ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
}
