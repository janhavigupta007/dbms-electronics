package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Item;

public interface CartDao{
	public List<Item> getCart(final String customerid);
	public void addToCart(String customerid, int productid);
	public void deleteFromCart(String customerid, int productid);
}