package com.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra.model.WorkternSystemEntity;
import com.ra.repository.WorkternSystemRepository;

@Service
public class WorkternSystemService {

	@Autowired
	public WorkternSystemRepository workternsystemrepository;
	public void save(WorkternSystemEntity systementry) {
		workternsystemrepository.save(systementry);
		
	}

}
