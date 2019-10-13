package com.janhavi.model;

public class Product{
	private int productid;
	private String name;
	private String brand;
	private int price;
	private String category;
	private int quantity;
	
	
	public Product() {}
	public Product( int productid, String name, String brand, int price, String category, int quantity) {
		super();
		this.productid = productid;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}