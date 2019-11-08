package com.janhavi.model;

public class Proposal{
	private Partner partner;
	private int price;
	
	public Proposal() {}
	public Proposal(Partner partner, int price) {
		super();
		this.partner = partner;
		this.price = price;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}