package com.cg.banking.bean;

import java.sql.Date;

public class CustomerBean {
	private long accNo;
	private String name;
	private String email;
	private String address;
	private String pancard;
	private String mobile;
	private int acctype;
	private int accbal;
	private String date;
	
	
	
	
	
	
	
	
	public CustomerBean(String name, String email, String address,
			String pancard, String mobile, int acctype, int accbal, String date) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile = mobile;
		this.acctype = acctype;
		this.accbal = accbal;
		this.date = date;
	}

	public CustomerBean(String name, String email, String address,
			String pancard, String mobile, int acctype, int accbal) {
		super();
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile = mobile;
		this.acctype = acctype;
		this.accbal = accbal;
		
	}

	public int getAcctype() {
		return acctype;
	}

	public void setAcctype(int acctype) {
		this.acctype = acctype;
	}

	public int getAccbal() {
		return accbal;
	}

	public void setAccbal(int accbal) {
		this.accbal = accbal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mob) {
		this.mobile = mob;
	}
	
	

	public CustomerBean(long accNo, String name, String email, String address,
			String pancard, String mobile) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
		this.mobile = mobile;
	}
	
	

	public CustomerBean(long accNo) {
		super();
		this.accNo = accNo;
	}

	public CustomerBean() {
	}
	
	public CustomerBean(String address, String mobile) {
		super();
		this.address = address;
		this.mobile = mobile;
	}

	
	
	
	

}
