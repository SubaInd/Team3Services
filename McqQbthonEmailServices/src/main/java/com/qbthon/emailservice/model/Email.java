package com.qbthon.emailservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Email {

	String emailType;
	String subject;
	String from;
	ArrayList<String> to;
	private ArrayList<MultipartFile> attachments;
	public String getEmailType() {
		return emailType;
	}
	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = (ArrayList<String>) to;
	}
	public List<MultipartFile> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<MultipartFile> attachments) {
		this.attachments = (ArrayList<MultipartFile>) attachments;
	}
	
	

	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}



	String body;
	
	
}
