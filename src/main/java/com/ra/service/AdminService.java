package com.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ra.model.AdminUser;
import com.ra.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	AdminRepository adminrepository;
	public AdminUser logIn(String email, String password) {
		System.out.println(adminrepository.findByEmailAndPassword(email,password));
		return adminrepository.findByEmailAndPassword(email,password);
	}
	public AdminUser getAdmin(int id) {
		return adminrepository.getById(id);
	}
	public void save(AdminUser admin) {
		adminrepository.save(admin);
		
	}

}
