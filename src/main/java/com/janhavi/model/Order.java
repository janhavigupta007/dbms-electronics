package com.janhavi.model;

public class Order{
	private int orderid;
	private Item item;
	
	
	public Order() {}
	public Order( int orderid, Item item) {
		super();
		this.orderid = orderid;
		this.item = item;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
}