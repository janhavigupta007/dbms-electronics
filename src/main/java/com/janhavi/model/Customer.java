package com.janhavi.model;

public class Customer{
	private String cid;
	private String name;
	private long contact;
	private String email;
	private int houseno;
	private String locality;
	private String city;
	
	public Customer() {}
	public Customer( String cid, 
			String name,long contact, String email,
			int houseno, String locality, String city) {
		super();
		this.cid = cid;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.houseno = houseno;
		this.locality = locality;
		this.city = city;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public int getHouseno() {
		return houseno;
	}

	public void setHouseno(int houseno) {
		this.houseno = houseno;
	}
	
	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}