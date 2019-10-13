package com.janhavi.model;

public class Proposal{
	private String partner;
	private int price;
	
	public Proposal() {}
	public Proposal(String partner, int price) {
		super();
		this.partner = partner;
		this.price = price;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}