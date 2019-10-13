package com.janhavi.model;

public class Feedback{
	private String username;
	private int rating;
	private String description;
	
	public Feedback() {}
	public Feedback( String username, int rating, String description) {
		super();
		this.username = username;
		this.rating = rating;
		this.description = description;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}