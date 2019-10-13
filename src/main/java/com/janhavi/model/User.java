package com.janhavi.model;

public class User{
	private String username;
	private String password;
	private int enabled;
	private String role;
	private String name;
	private long contact;
	private String email;
	
	
	public User() {}
	public User( String username, String password, int enabled, String role,
			String name,long contact, String email) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.name = name;
		this.contact = contact;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
}