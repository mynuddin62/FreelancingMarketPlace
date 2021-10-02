package com.ra.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ra.model.AdminUser;
import com.ra.model.ConsignmentsEntity;
import com.ra.model.OfferPostEntity;
import com.ra.model.SentRequestEntity;
import com.ra.model.Users;
import com.ra.model.WorkternSystemEntity;
import com.ra.service.AdminService;
import com.ra.service.ConsignmentsService;
import com.ra.service.OfferPostService;
import com.ra.service.SentRequestService;
import com.ra.service.UsersService;
import com.ra.service.WorkternSystemService;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class FirstController {
	@Autowired
	public UsersService userserv;
	@Autowired
	public OfferPostService offerpostservice;
	@Autowired
	public SentRequestService sentrequestservice;
	@Autowired
	public ConsignmentsService consingmentservice;
	@Autowired
	public WorkternSystemService workternsystemservice;
	@Autowired
	public AdminService adminservice;
	
	//context path::login page
	@GetMapping("/")
	public String signIn(Model model) {
		Users user = new Users();
		model.addAttribute("user",user);
		return "signin";
	}
	
	//for signup page
	@GetMapping("/signUp")
	public String signUp(Model model) {
		Users user = new Users();
		model.addAttribute("user",user);
		return "signup";
	}
	
	//userLogin through signin page.....
	@PostMapping("/logIn")
	public String login(@ModelAttribute("user")Users user,Model model) {
		
		Users us = userserv.logIn(user.getEmail(), user.getPassword());
		
		if(Objects.nonNull(us)) {
			model.addAttribute("useer",us);
			List<OfferPostEntity> alloffers = offerpostservice.getAllOffers();
			System.out.println(alloffers.size());
			
			model.addAttribute("size", alloffers.size());
			model.addAttribute("offerlists", alloffers);
			//return "example";
			return "index2";
		}
		{
			model.addAttribute("invalid", true);
			return "signin";
		}
	}
	
	//usercreating through signup page
	@PostMapping("/userCreate")
	public String signup(Users user) {
		user.setRole("user");
		userserv.signUp(user);
		//System.out.println(user.getName());
		return "redirect:/";
	}
	@GetMapping("/userProfile")
	public String userProfile() {
		
		return "dashboard-myprofile";
	}
	@GetMapping("/test")
	public String tests() {
		return "index";
	}

	@GetMapping("/accepting")
	public String buyerAccept(@RequestParam("userId") int id,Model model) {
		List<SentRequestEntity> sellerlist = sentrequestservice.sellerList(id);
		Users buyer = userserv.getUser(id);
		
		model.addAttribute("sellerList", sellerlist);
		return "dashboard-qus-ans";
	}
	@GetMapping("/tosee")
	public String tosee(@RequestParam("acceptId") int id, Model model) {
		Date orderrecievedate = new Date();
		SentRequestEntity consignment = sentrequestservice.getConsignment(id); 
		int buyerid = consignment.getRequesttoid();
		int sellerid = consignment.getRequestfromid();
		Long orderid = consignment.getOfferid();
		int buyerbudget = consignment.getRequesttobudget();
		int buyerduration = consignment.getRequesttoduration();
		System.out.println("buyerid" +buyerid);
		System.out.println("sellerid"+sellerid);
		System.out.println("orderid" +orderid);
		System.out.println("budget"  +buyerbudget);
		System.out.println("duratoin"+buyerduration);
		System.out.println(id); 
		Date orderdeliverydate = new Date(orderrecievedate.getTime() + (1000 * 60 * 60 * 24 * buyerduration ));
		System.out.println("orderrecievedate is .......    "+ orderrecievedate);
		System.out.println("orderdeliverydate is .....   " + orderdeliverydate );
		
		Users buyer = userserv.getUser(buyerid);
		Users seller = userserv.getUser(sellerid);
		
		String buyername = buyer.getName();
		String sellername = seller.getName();
		System.out.println("buyername" + buyername);
		System.out.println("sellername" + sellername);
		
		ConsignmentsEntity  addconsignment = new ConsignmentsEntity();
		addconsignment.setBuyerid(buyerid);
		addconsignment.setBuyername(buyername);
		addconsignment.setOrderid(orderid);
		addconsignment.setDeliverydate(orderdeliverydate);
		addconsignment.setTotalbudget(buyerbudget);
		addconsignment.setSellerid(sellerid);
		addconsignment.setSellername(sellername);
		consingmentservice.save(addconsignment);
		
		buyer.setAmount(buyer.getAmount()-buyerbudget);
		userserv.signUp(buyer);
		WorkternSystemEntity systementry = new WorkternSystemEntity();
		systementry.setBuyerid(buyerid);
		systementry.setBuyername(buyername);
		systementry.setSellerid(sellerid);
		systementry.setSellername(sellername);
		systementry.setDeductionamount(buyerbudget);
		
		workternsystemservice.save(systementry);
		model.addAttribute("user",buyer);
		
		return "dashboard-privacysetting";
	}
	
	@GetMapping("/seller")
	public String activeOrders(@RequestParam("userId") int id, Model model) {
		ConsignmentsEntity orders = consingmentservice.getOrdersBySeller(id);
		System.out.println(orders.getOrderid());
		System.out.println(orders.getBuyername()+"     "+ orders.getBuyerid());
		System.out.println(orders.getDeliverydate());
		System.out.println(orders.getTotalbudget());
		model.addAttribute("orders", orders);
		return "activeorders";
	}
	@GetMapping("/confirming")
	public String confirmed(@RequestParam("userId") int id, Model model) {
		ConsignmentsEntity orders = consingmentservice.getOrdersByBuyer(id);
		System.out.println(orders.getSellername()+"  "+orders.getOrderid()+"   "+ orders.getDeliverydate()+"   "+ orders.getTotalbudget());
		 
		model.addAttribute("orders", orders);
		return "liveservice";
	}
	@GetMapping("/submitting")
	public String SendingWork(@RequestParam("userId") int id, Model model) {
		ConsignmentsEntity orders = consingmentservice.getOrdersBySeller(id);
		
		model.addAttribute("orders",orders);
		
		return "sellersubmit";
	}
	@GetMapping("/serviceAccepted")
	public String serviceAccepted(@RequestParam("userId") int id, Model model) {
		ConsignmentsEntity orders = consingmentservice.getOrdersByBuyer(id);
		 int sellerid = orders.getSellerid();
		 int budget = orders.getTotalbudget();
		 Users seller = userserv.getUser(sellerid);
		 int sellerget = (int) (budget * 0.8); 
		 int admintget = (int) (budget * 0.2);
		 System.out.println(seller.getAmount());
		 System.out.println(sellerget);
		 
		 seller.setAmount(seller.getAmount()+sellerget);
		 
		 
		 userserv.signUp(seller);
		 AdminUser admin = adminservice.getAdmin(1);
		 admin.setAmount(admin.getAmount()+admintget);
		 adminservice.save(admin);
		return "confirmingbybuyer";
	}
	
	
}
