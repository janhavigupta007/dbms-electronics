package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Order;

public interface OrderDao{
	public int placeOrder(String customerid);
	public List<Order> getOrders(final String customerid);
	public List<Order> getAllOrders();
}