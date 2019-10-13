package com.janhavi.model;

public class Cart{
	private String customerid;
	private Item item;
	
	
	public Cart() {}
	public Cart( String customerid, Item item) {
		super();
		this.customerid = customerid;
		this.item = item;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}