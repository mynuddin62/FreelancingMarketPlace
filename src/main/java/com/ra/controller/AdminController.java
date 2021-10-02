package com.ra.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ra.model.AdminUser;

import com.ra.service.AdminService;


@Controller
public class AdminController {
	@Autowired
	AdminService adminservice;
	
	@GetMapping("/adminsignin")
	public String signIn(Model model) {
		AdminUser user = new AdminUser();
		model.addAttribute("user",user);
		return "signin";
	}
	@PostMapping("/adminLogIn")
	public String login(@ModelAttribute("user")AdminUser user,Model model) {
		
		AdminUser us = adminservice.logIn(user.getEmail(), user.getPassword());
		System.out.println(us.getEmail()+" "+us.getPassword());
		
		if(Objects.nonNull(us)) {
			model.addAttribute("adminuser",us);
			return "example";
		
		}
		{
			model.addAttribute("invalid", true);
			return "signin";
		}
	}
	@GetMapping("/intromap")
	public String introduction() {
		return "introduction";
	}
}
