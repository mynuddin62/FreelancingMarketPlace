package com.ra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consignments")
public class ConsignmentsEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private long orderid;
	@Column
	private int buyerid;
	@Column
	private String buyername;
	@Column
	private int sellerid;
	@Column
	private String sellername;
	@Column
	private Date deliverydate;
	@Column
	private int totalbudget;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public int getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(int buyerid) {
		this.buyerid = buyerid;
	}
	public String getBuyername() {
		return buyername;
	}
	public void setBuyername(String buyername) {
		this.buyername = buyername;
	}
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getSellername() {
		return sellername;
	}
	public void setSellername(String sellername) {
		this.sellername = sellername;
	}
	public Date getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}
	public int getTotalbudget() {
		return totalbudget;
	}
	public void setTotalbudget(int totalbudget) {
		this.totalbudget = totalbudget;
	}
	public ConsignmentsEntity() {
		super();
	}
	public ConsignmentsEntity(int id, long orderid, int buyerid, String buyername, int sellerid, String sellername,
			Date deliverydate, int totalbudget) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.buyerid = buyerid;
		this.buyername = buyername;
		this.sellerid = sellerid;
		this.sellername = sellername;
		this.deliverydate = deliverydate;
		this.totalbudget = totalbudget;
	}
	
	
	
	
}
