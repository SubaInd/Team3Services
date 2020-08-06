package com.qthonservices.practisemcqservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.qthonservices.practisemcqservices.models.PractiseMcq;
import com.qthonservices.practisemcqservices.services.PractiseMcqService;



@CrossOrigin
@RestController
public class PractiseMcqController {

	private static final Logger logger = LoggerFactory.getLogger(PractiseMcqController.class);
	@Autowired
	PractiseMcqService practiseMcqService;
	
	@RequestMapping(value = "/savePractiseMcq/", method = RequestMethod.POST,headers = "Accept=application/json",produces = "application/json")
	
	public ResponseEntity<Object> submitPractiseMCq(@RequestBody PractiseMcq practiseMcq) {
		practiseMcqService.submitPractiseMCQ(practiseMcq);
		logger.info("Submitted Parctise Questions");
		return new ResponseEntity<>("submitted your practise question",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getAllsubmittedPractisemcqs",method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object> getAllsubmitedPractisemcqs() {
		List<PractiseMcq>practiseMcqlist =practiseMcqService.getAllSubmittedMcqs();
		return new ResponseEntity<>(practiseMcqlist,HttpStatus.OK);
	}
	
	@GetMapping(value="/getAllreviewededPractisemcqs",produces = "application/json")
	public ResponseEntity<Object> getReviwedPractisemcqs() {
		List<PractiseMcq>practiseMcqlist =practiseMcqService.getAllSubmittedMcqs();
		return new ResponseEntity<>(practiseMcqlist,HttpStatus.OK);
	}
	
	
	
	
}
