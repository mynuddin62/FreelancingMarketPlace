package com.ra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sent_request")
public class SentRequestEntity {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String requestcode;
	@Column
	private int requestfromid;
	@Column
	private int requesttoid;
	@Column
	private Long offerid;
	@Column
	private String requestfromidname;
	@Column
	private int requesttobudget;
	@Column
	private int requesttoduration;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRequestcode() {
		return requestcode;
	}
	public void setRequestcode(String requestcode) {
		this.requestcode = requestcode;
	}
	public int getRequestfromid() {
		return requestfromid;
	}
	public void setRequestfromid(int requestfromid) {
		this.requestfromid = requestfromid;
	}
	public int getRequesttoid() {
		return requesttoid;
	}
	public void setRequesttoid(int requesttoid) {
		this.requesttoid = requesttoid;
	}
	public Long getOfferid() {
		return offerid;
	}
	public void setOfferid(Long offerid) {
		this.offerid = offerid;
	}
	
	public String getRequestfromidname() {
		return requestfromidname;
	}
	public void setRequestfromidname(String requestfromidname) {
		this.requestfromidname = requestfromidname;
	}
	public int getRequesttobudget() {
		return requesttobudget;
	}
	public void setRequesttobudget(int requesttobudget) {
		this.requesttobudget = requesttobudget;
	}
	public int getRequesttoduration() {
		return requesttoduration;
	}
	public void setRequesttoduration(int requesttoduration) {
		this.requesttoduration = requesttoduration;
	}
	public SentRequestEntity() {
		super();
	}
	public SentRequestEntity(int id, String requestcode, int requestfromid, int requesttoid, Long offerid) {
		super();
		this.id = id;
		this.requestcode = requestcode;
		this.requestfromid = requestfromid;
		this.requesttoid = requesttoid;
		this.offerid = offerid;
	}
	
	
}
