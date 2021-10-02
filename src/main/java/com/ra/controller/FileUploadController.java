package com.ra.controller;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ra.model.OfferPostEntity;
import com.ra.model.SentRequestEntity;
import com.ra.model.Users;
import com.ra.service.OfferPostService;
import com.ra.service.SentRequestService;
import com.ra.service.UsersService;


@Controller
public class FileUploadController {
	@Autowired
	public OfferPostService offerpostservice;
	@Autowired
	public UsersService userservice;
	@Autowired
	public SentRequestService sentrequestservice;
	
	@GetMapping("/postoffer")
	public String postOffer(Model model,@RequestParam("id") int id) {
		Users user = userservice.getUser(id);
		System.out.println(user.getAmount());
		List<String> category = Arrays.asList("Digital Marketing" , "Video And Animation" , "Writing And Translation" , "Programming And Tech" , "Fun And Style" , "Music And Audio" , "Bussiness");
		model.addAttribute("user", user);
		model.addAttribute("category",category);
		OfferPostEntity offerpost = new OfferPostEntity();
		offerpost.setPostedbyid(id);
		System.out.println("id from postoffer... "+ offerpost.getPostedbyid());
		model.addAttribute("offerpost",offerpost);
		return "dashboard-postajob";
	}
	@PostMapping("/offerPosted")
	public String offerPosted(@ModelAttribute("offerpost") OfferPostEntity offerpostentity,Model model) {
		//System.out.println(offerpostentity.getCategory());
		//System.out.println(offerpostentity.getDescription());
	    Date date = new Date();
	    //SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	    //String currentdate = formater.format(date);
	    System.out.println("Hi" + "...."  );
	    System.out.println(offerpostentity.getPostedbyid());
	    Users user = userservice.getUser(offerpostentity.getPostedbyid());
	    model.addAttribute("useer",user);
	    
		offerpostentity.setUploadtime(date);
		offerpostservice.saveOffer(offerpostentity);
		
		return "index2";
	}
	@GetMapping("/offerList")
	public String offerList(Model model) {
		
		List<OfferPostEntity> alloffers = offerpostservice.getAllOffers();
		/*
		 * for (OfferPostEntity onebyone : alloffers) {
		 * System.out.println(onebyone.getDescription());
		 * System.out.println(onebyone.getBudget()); }
		 */
		
		model.addAttribute("offerlists", alloffers);
		return "employersgrid";
	}
	
	@GetMapping("/getOffer")
	public String getOffer(@RequestParam("offerId") long offerId, @RequestParam("userId") int userId, Model model) {
		OfferPostEntity postoffer = offerpostservice.getPostoffer(offerId);
		System.out.println("Budget: "+postoffer.getBudget()+"  "+"Duration "+ postoffer.getDelevarydays() +" "+ " buyerId : "+ postoffer.getPostedbyid() );
		//System.out.println("offer id is: " + offerId + " user id is: " + userId);
		Users user = userservice.getUser(userId);
		SentRequestEntity sentrequest = new SentRequestEntity();
		sentrequest.setOfferid(offerId);
		sentrequest.setRequestfromid(userId);
		sentrequest.setRequestfromidname(user.getName());
		sentrequest.setRequesttobudget(postoffer.getBudget());
		sentrequest.setRequesttoduration(postoffer.getDelevarydays());
		sentrequest.setRequesttoid(postoffer.getPostedbyid());
		sentrequestservice.save(sentrequest);
		
		model.addAttribute("useer",user);
		model.addAttribute("requestsuccess", true);
		return "index2";
	}
	@GetMapping("/addmoney")
	public String addmoney(@RequestParam("id") int userId,Model model) {
		Users user = new Users();
		user.setId(userId);
		model.addAttribute("user",user);
		System.out.println(userId);
		return "moneyadd";
	}
	@GetMapping("/withdraw")
	public String withdraw(@RequestParam("id") int userId,Model model) {
		Users user = new Users();
		user.setId(userId);
	
		model.addAttribute("user",user);
		return "withdrawmoney";
	}
	@PostMapping("/addamount")
	public String addmoneypost(@ModelAttribute("user")Users user) {
		System.out.println(user.getAmount());
		System.out.println(user.getId());
		Users adduser = userservice.getUser(user.getId());
		float moneyfromadduser = adduser.getAmount();
		moneyfromadduser = moneyfromadduser + user.getAmount();
		adduser.setAmount(moneyfromadduser);
		userservice.signUp(adduser);
		System.out.println(moneyfromadduser);
		return "congratulations";
	}
	@PostMapping("/withamount")
	public String withmoneypost(@ModelAttribute("user")Users user) {
		System.out.println(user.getAmount()+".....withdraw");
		Users adduser = userservice.getUser(user.getId());
		float moneyfromadduser = adduser.getAmount();
		moneyfromadduser = moneyfromadduser - user.getAmount();
		adduser.setAmount(moneyfromadduser);
		userservice.signUp(adduser);
		System.out.println(moneyfromadduser);
		return "congratulations";
	}
}
