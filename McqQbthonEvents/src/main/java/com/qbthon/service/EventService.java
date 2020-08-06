package com.qbthon.service;

import java.io.IOException;
import java.util.List;

import com.qbthon.model.EventDetails;
import com.qbthon.model.Skillsets;

public interface EventService {
	
	public List<Skillsets> getSkillsList();
	
	public List<String> getAllnonNominatedAssociates(String eventName);
	
	public List<String> getAllNominatedAssociates(String eventName);
	
	public List<String> getAllEventNames();
	
	public String createEvent(EventDetails eventDet) throws IOException;

}
