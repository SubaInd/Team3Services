package com.qbthon.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemCollection;
import com.amazonaws.services.dynamodbv2.document.ScanOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.qbthon.model.AssociateDetails;

import com.qbthon.model.EventDetails;
import com.qbthon.model.Eventassociates;
import com.qbthon.model.Skillsets;
import com.qbthon.repositories.EventAssociatesRepository;
import com.qbthon.repositories.SkillsRepo;

@Service
public class EventServiceImpl implements EventService{

	private static final String EVENTNAME = "eventName";
	
	@Autowired 
	private DynamoDBMapper dynamoDBMapper;

	@Autowired
	AmazonDynamoDB amazonDynamoDB;



	@Autowired
	SkillsRepo skillsRepo;
	
	@Autowired
	EventAssociatesRepository eventAssociatesRepository;

	public List<Skillsets> getSkillsList() {

		List<Skillsets> skills = new ArrayList<>();
		skills.addAll(skillsRepo.findAll());


		return skills;
	}
	
	
	public List<String> getAllnonNominatedAssociates(String eventName){
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable("event_associates");
		HashMap<String, String> nameMap = new HashMap<>();
        nameMap.put("#nm", "nominated");
        nameMap.put("#evnam", EVENTNAME);
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(":nmvalue", "No");
        valueMap.put(":evval",eventName );
        ArrayList<String> emails = new ArrayList<>();

		ScanSpec scanSpec = new ScanSpec().withProjectionExpression("associateEmail").withFilterExpression("#nm = :nmvalue and #evnam = :evval").withNameMap(nameMap).withValueMap(valueMap);
		 ItemCollection<ScanOutcome> items = table.scan(scanSpec);
		 Iterator<Item> iter = items.iterator();
		 while (iter.hasNext()) {
             Item item = iter.next();
             String torip = item.toString();
				
            emails.add(torip.substring(torip.indexOf('=')+1,torip.indexOf('}')));
             
             
         }
			return emails;
		 
		 
	}
	
	public List<String> getAllNominatedAssociates(String eventName){
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		Table table = dynamoDB.getTable("event_associates");
		HashMap<String, String> nameMap = new HashMap<>();
        nameMap.put("#nm", "nominated");
        nameMap.put("#evnam", EVENTNAME);
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put(":nmvalue", "Yes");
        valueMap.put(":evval",eventName );
        ArrayList<String> emails = new ArrayList<>();

		ScanSpec scanSpec = new ScanSpec().withProjectionExpression("associateEmail").withFilterExpression("#nm = :nmvalue and #evnam = :evval").withNameMap(nameMap).withValueMap(valueMap);
		 ItemCollection<ScanOutcome> items = table.scan(scanSpec);
		 Iterator<Item> iter = items.iterator();
		 while (iter.hasNext()) {
             Item item = iter.next();
             String torip = item.toString();
				
            emails.add(torip.substring(torip.indexOf('=')+1,torip.indexOf('}')));
             
             
         }
			return emails;
		 
		 
	}
	
	
	public List<String> getAllEventNames() {
		
		
		DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
		ArrayList<String> events = new ArrayList<>();
		Table emailTemplateTable = dynamoDB.getTable("event_details"); 
		ScanSpec scanSpec = new ScanSpec().withProjectionExpression(EVENTNAME);
		 ItemCollection<ScanOutcome> items = emailTemplateTable.scan(scanSpec);
		 Iterator<Item> iter = items.iterator();
         while (iter.hasNext()) {
             Item item = iter.next();
             String torip = item.toString();
				
            events.add(torip.substring(torip.indexOf('=')+1,torip.indexOf('}')));             

         }
			
         
         return events;
	}
	

	public String createEvent(EventDetails eventDet) throws IOException {

					
		String eventId = "event"+System.currentTimeMillis();
		Item item = new Item().withPrimaryKey("eventId", eventId)
				.withString(EVENTNAME, eventDet.getEventName())
				.withList("eventSkills", eventDet.getEventSkills())
				.withString("eventDate", eventDet.getEventDate().toString())
				.withString("eventSlot", eventDet.getEventSlot());
		
		AssociatesExcelParser parseAssociates = new AssociatesExcelParser();
		
		item.withList("Associates", parseAssociates.parseExcel(eventDet));
		
		ExcelParser parseSmes = new SmeExcelParser();
		
		item.withList("Smes", parseSmes.parseExcel(eventDet));
		
       List<String> emails = new ArrayList<>();
		
			List<AssociateDetails> associateinfolist = parseAssociates.getAssociatesForEvent();
			
			Eventassociates obj = new Eventassociates();
			for(int i=0;i<associateinfolist.size();i++) {
				emails.add(associateinfolist.get(i).getEmail());				
				
				obj.setAssociateEmail(associateinfolist.get(i).getEmail());
				obj.setAssociatename(associateinfolist.get(i).getAssociateName());
				obj.setEventId(eventId);
				obj.setEventName(eventDet.getEventName());
				obj.setNominated("No");
				obj.setId(associateinfolist.get(i).getAssociateName()+"_"+eventDet.getEventName()+"_"+System.currentTimeMillis());
				eventAssociatesRepository.save(obj);
				
			}
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<List<String>> entity = new HttpEntity<>(emails, headers);
			
			String sendemailUrl
			  = "http://localhost:8005/qbthonEvents-emailservice/sendmailtolist/createEvent/";
			ResponseEntity<String> response = restTemplate.exchange(sendemailUrl, HttpMethod.POST, entity, String.class);
			if(response.getStatusCodeValue()!=200) {
				return "created event but couldnt send mai at this time please user trigger mail page and try again";
			}
			return "created event and "+response.getBody();
			
			
		
	}

	
}
