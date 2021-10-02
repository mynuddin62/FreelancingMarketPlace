package com.ra.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "offerpost")
public class OfferPostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String postcode;
	private String category;
	private String description;
	private int delevarydays;
	private int budget;
	private long size;
	private Date uploadtime;
	private int postedbyid;
	
	//private byte[] content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDelevarydays() {
		return delevarydays;
	}

	public void setDelevarydays(int delevarydays) {
		this.delevarydays = delevarydays;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public int getPostedbyid() {
		return postedbyid;
	}

	public void setPostedbyid(int postedbyid) {
		this.postedbyid = postedbyid;
	}

	//public byte[] getContent() {
		//return content;
	//}

	//public void setContent(byte[] content) {
		//this.content = content;
	//}
	
	
}
