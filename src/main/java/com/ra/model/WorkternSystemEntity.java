package com.ra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="worktern_system")
public class WorkternSystemEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int buyerid;
	@Column
	private String buyername;
	@Column
	private int sellerid;
	@Column
	private String sellername;
	@Column
	private int deductionamount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDeductionamount() {
		return deductionamount;
	}
	public void setDeductionamount(int deductionamount) {
		this.deductionamount = deductionamount;
	}
	public WorkternSystemEntity() {
		super();
	}
	public WorkternSystemEntity(int id, int buyerid, String buyername, int sellerid, String sellername,
			int deductionamount) {
		super();
		this.id = id;
		this.buyerid = buyerid;
		this.buyername = buyername;
		this.sellerid = sellerid;
		this.sellername = sellername;
		this.deductionamount = deductionamount;
	}
	
}
