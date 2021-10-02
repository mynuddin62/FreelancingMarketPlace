package com.ra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra.model.SentRequestEntity;
import com.ra.repository.SentRequestRepository;

@Service
public class SentRequestService {
	
	@Autowired
	public SentRequestRepository sentrequestrepository;
	public void save(SentRequestEntity sentrequest) {
		sentrequestrepository.save(sentrequest);
		
	}
	public List<SentRequestEntity> sellerList(int id) {
		return sentrequestrepository.findByRequesttoid(id);
	}
	public  SentRequestEntity getConsignment(int id) {
		return sentrequestrepository.findById(id).get();
	}
	  
}
