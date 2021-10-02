package com.ra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.ra.model.Users;
import com.ra.repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	UsersRepository userrepo;
	
	public Users logIn(String email, String password) {
		Users user = userrepo.findByEmailAndPassword(email, password);
		return user;
		}
	
	public void signUp(Users user) {
		userrepo.save(user);
	}

	public Users getUser(int id) {
		return userrepo.findById(id).get();
	}
	

	
	
}
