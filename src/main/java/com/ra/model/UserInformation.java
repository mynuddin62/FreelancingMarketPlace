package com.ra.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_information")
public class UserInformation {
	@Id 
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String email;
	@Column
	private String firstname;
	@Column
	private String middlename;
	@Column
	private String lastname;
	@Column
	private String fathername;
	@Column
	private Date dateofbirth;
	@Column
	private String month;
	@Column 
	private String maritalstatus;
	@Column
	private long passportnumber;
	@Column
	private String address;
	
	
}
