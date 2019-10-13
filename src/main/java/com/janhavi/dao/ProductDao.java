package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Category;
import com.janhavi.model.Product;


public interface ProductDao{
	
	public List<Product> findAll();
	public int addProduct(Product product);
	public int addCategory(Category category);
	public int addProposal(String partnerid, int productid, int price);
}