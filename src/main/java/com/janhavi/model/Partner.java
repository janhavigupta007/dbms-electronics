package com.janhavi.model;

public class Partner{
	private String pid;
	private String name;
	private String firm;
	private long contact;
	private String email;
	
	public Partner() {}
	public Partner( String pid, 
			String name,String firm, long contact, String email) {
		super();
		this.pid = pid;
		this.name = name;
		this.firm = firm;
		this.contact = contact;
		this.email = email;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFirm() {
		return firm;
	}

	public void setFirm(String firm) {
		this.firm = firm;
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
	
}