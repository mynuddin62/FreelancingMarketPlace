package com.ra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra.model.OfferPostEntity;
import com.ra.repository.OfferPostRepository;

@Service
public class OfferPostService {
	@Autowired
	public OfferPostRepository offerpostrepository;
	
	public void saveOffer(OfferPostEntity offerpostentity) {
		offerpostrepository.save(offerpostentity);
		
	}
	
	public List<OfferPostEntity> getAllOffers() {
		
		return offerpostrepository.findAll();
	}

	public OfferPostEntity getPostoffer(long offerId) {
		return offerpostrepository.getById(offerId);
	}

	public List<OfferPostEntity> sellerList(int id) {
		return offerpostrepository.findByPostedbyid(id);
	}

	

}
