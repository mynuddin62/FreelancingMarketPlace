package com.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra.model.ConsignmentsEntity;
import com.ra.repository.ConsignmentsRepository;

@Service
public class ConsignmentsService {
	
	@Autowired
	public ConsignmentsRepository consignmentrepository;
	
	public void save(ConsignmentsEntity addconsignment) {
		consignmentrepository.save(addconsignment);
		
	}

	public ConsignmentsEntity getOrdersBySeller(int id) {
		
		return consignmentrepository.getBySellerid(id);
	}

	public ConsignmentsEntity getOrdersByBuyer(int id) {
		return consignmentrepository.getByBuyerid(id);
	}

}
