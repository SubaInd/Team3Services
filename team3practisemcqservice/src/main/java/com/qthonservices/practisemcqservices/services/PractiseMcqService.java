package com.qthonservices.practisemcqservices.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qthonservices.practisemcqservices.models.PractiseMcq;
import com.qthonservices.practisemcqservices.repositories.PractiseMcqRepository;

@Service
public class PractiseMcqService {
@Autowired 
PractiseMcqRepository practiseMcqRepository;
	
	public void submitPractiseMCQ(PractiseMcq practiseMcq) {
		
		practiseMcqRepository.save(practiseMcq);
	}
	
	public void updateStatus(String id,String status) {
		Optional<PractiseMcq> mcq =practiseMcqRepository.findById(id);
		if(mcq.isPresent()) {
		PractiseMcq mcqobj = mcq.get();
		mcqobj.setStatus(status);
		practiseMcqRepository.save(mcqobj);
		}
		
	}
	public List<PractiseMcq> getAllSubmittedMcqs(){
		List<PractiseMcq> all =(List<PractiseMcq>) practiseMcqRepository.findAll();
		Iterator<PractiseMcq> itr = all.iterator();
		List<PractiseMcq> retlist = new ArrayList<>();
		while(itr.hasNext()) {
			PractiseMcq obj = itr.next();
			if(obj.getStatus().equals("submitted") && obj.getComments()=="" ) {
				retlist.add(obj);
			}
		}
		return retlist;
	}
	
	public List<PractiseMcq> getAllreviewedMcqs(){
		List<PractiseMcq> all =(List<PractiseMcq>) practiseMcqRepository.findAll();
		Iterator<PractiseMcq> itr = all.iterator();
		List<PractiseMcq> retlist = new ArrayList<>();
		while(itr.hasNext()) {
			PractiseMcq obj = itr.next();
			if(obj.getStatus().equals("Reviewed")) {
				retlist.add(obj);
			}
		}
		return retlist;
	}
}
