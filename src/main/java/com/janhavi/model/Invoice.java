package com.janhavi.model;

public class Invoice{
	private int invoiceid;
	private String customerid ;
	private String dateofissue;
	private String paymentmethod;
	
	
	public Invoice() {}
	public Invoice(int invoiceid, String customerid, String dateofissue, String paymentmethod) {
		super();
		this.invoiceid = invoiceid;
		this.customerid = customerid;
		this.dateofissue = dateofissue;
		this.paymentmethod = paymentmethod;
	}
	public int getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getDateofissue() {
		return dateofissue;
	}
	public void setDateofissue(String dateofissue) {
		this.dateofissue = dateofissue;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
}