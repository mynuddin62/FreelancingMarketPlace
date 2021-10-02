package com.ra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin_user")
public class AdminUser {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
	private double amount;
	public AdminUser() {
		super();
	}
	public AdminUser(int id) {
		super();
		this.id = id;
	}
	
	public AdminUser(String password, String email) {
		super();
		this.password = password;
		this.email = email;
	}
	public AdminUser(String name, String password, String email, double amount) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.amount = amount;
	}
	public AdminUser(String name, String password, String email, int id, double amount) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.id = id;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
