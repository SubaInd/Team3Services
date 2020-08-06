package com.qbthon.model;

import java.util.Date;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;


public class EventDetails {
	
	private String eventId;
	
	private String eventName;
	
	private Date eventDate;
	
	private String eventSlot;
	
	private String eventstartTime;
	
	private String eventEndTime;
	
	private Set<String> eventSkills;
	
	
	
	private Integer totalNoOfSkillsCovered;
	
	private Integer totalNoOfMCQs;
	
	
	private Set<String> voucherWinners;
	
	private MultipartFile uploadFileAssociates;
	
	private MultipartFile uploadFilesmes;
	
	
	public MultipartFile getUploadFileAssociates() {
		return uploadFileAssociates;
	}


	public void setUploadFileAssociates(MultipartFile uploadFileAssociates) {
		this.uploadFileAssociates = uploadFileAssociates;
	}


	public MultipartFile getUploadFilesmes() {
		return uploadFilesmes;
	}


	public void setUploadFilesmes(MultipartFile uploadFilesmes) {
		this.uploadFilesmes = uploadFilesmes;
	}


	public EventDetails() {
		super();
	}

	
	public EventDetails(String eventId, String eventName, Date eventDate, String eventSlot, String eventstartTime,
			String eventEndTime, Set<String> eventSkills
			) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventSlot = eventSlot;
		this.eventstartTime = eventstartTime;
		this.eventEndTime = eventEndTime;
		this.eventSkills = eventSkills;
		
		
	}
	
	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	
	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	
	public String getEventSlot() {
		return eventSlot;
	}

	public void setEventSlot(String eventSlot) {
		this.eventSlot = eventSlot;
	}

	
	public Set<String> getEventSkills() {
		return eventSkills;
	}

	public void setEventSkills(Set<String> eventSkills) {
		this.eventSkills = eventSkills;
	}

	
	public Integer getTotalNoOfSkillsCovered() {
		return totalNoOfSkillsCovered;
	}

	public void setTotalNoOfSkillsCovered(Integer totalNoOfSkillsCovered) {
		this.totalNoOfSkillsCovered = totalNoOfSkillsCovered;
	}

	
	public Integer getTotalNoOfMCQs() {
		return totalNoOfMCQs;
	}

	public void setTotalNoOfMCQs(Integer totalNoOfMCQs) {
		this.totalNoOfMCQs = totalNoOfMCQs;
	}

	
	public Set<String> getVoucherWinners() {
		return voucherWinners;
	}

	public void setVoucherWinners(Set<String> voucherWinners) {
		this.voucherWinners = voucherWinners;
	}

	
	public String getEventstartTime() {
		return eventstartTime;
	}


	public void setEventstartTime(String eventstartTime) {
		this.eventstartTime = eventstartTime;
	}

	
	public String getEventEndTime() {
		return eventEndTime;
	}
	
	
		public void setEventEndTime(String eventEndTime) {
		this.eventEndTime = eventEndTime;
	}


	@Override
	public String toString() {
		return "EventDetails [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", eventSlot=" + eventSlot + ", eventstartTime=" + eventstartTime + ", eventEndTime=" + eventEndTime
				+ ", eventSkills=" + eventSkills 
				+ ", totalNoOfSkillsCovered=" + totalNoOfSkillsCovered + ", totalNoOfMCQs=" + totalNoOfMCQs
				+ ", voucherWinners=" + voucherWinners + "]";
	}

}
