package com.ra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class Users {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String password;
	@Column
	private String email;
	@Column
	private String usercode;
	@Column
	private float amount;
	@Column
	private String role;
	@Column
	private String[] servicecategory;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String[] getServicecategory() {
		return servicecategory;
	}
	public void setServicecategory(String[] servicecategory) {
		this.servicecategory = servicecategory;
	}
	public Users() {
		super();
	}
	public Users(String name, String password, String email, String usercode, float amount, String role,
			String[] servicecategory) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.usercode = usercode;
		this.amount = amount;
		this.role = role;
		this.servicecategory = servicecategory;
	}
	public Users(int id, String name, String password, String email, String usercode, float amount, String role,
			String[] servicecategory) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.usercode = usercode;
		this.amount = amount;
		this.role = role;
		this.servicecategory = servicecategory;
	}
	public Users(int id) {
		super();
		this.id = id;
	}
	
		
	
	
	
}
