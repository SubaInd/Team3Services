package com.qbthon.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.qbthon.model.EventDetails;
import com.qbthon.model.Skillsets;
import com.qbthon.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/qbthonInfo")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/getDistinctSkills")
	public ResponseEntity<List<Skillsets>> getDistinctSkills() {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getSkillsList());
	}
	
	
	
	@PostMapping("/createEventDetails")
	public ResponseEntity<Object> createEvent(@ModelAttribute EventDetails eventDetails) {
		
		try {
		
			String message  = eventService.createEvent(eventDetails);
			
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		catch(Exception ex){			
			return new ResponseEntity<>("Cant create event",HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAllEvents")
	public ResponseEntity<Object> getAllEventNames() {
		try {
		return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllEventNames());
		}
		catch(Exception ex) {
			return new ResponseEntity<>("Error occred getting all event name"+ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/getAllNonNominatedAsociatesEmail/{eventname}/", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object>  getAllnonNominatedAssociatesEmail(HttpServletRequest request, @PathVariable("eventname") String eventname) {
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllnonNominatedAssociates(eventname));
			}
			catch(Exception ex) {
				return new ResponseEntity<>("Error occurred while getting all non-nominated associates email"+ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	
	@RequestMapping(value = "/getAllNominatedAsociatesEmail/{eventname}/", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Object>  getAllNominatedAssociatesEmail(HttpServletRequest request, @PathVariable("eventname") String eventname) {
	
		try {
			return ResponseEntity.status(HttpStatus.OK).body(eventService.getAllNominatedAssociates(eventname));
			}
			catch(Exception ex) {
				return new ResponseEntity<>("Error occurred while getting all nominated associates email"+ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
	

}
