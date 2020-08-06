package com.qbthon.service;

import java.io.IOException;
import java.util.List;

import com.qbthon.model.EventDetails;


public interface ExcelParser {
	
	
	public List<String> parseExcel(EventDetails eventDetails) throws IOException;
    
}
