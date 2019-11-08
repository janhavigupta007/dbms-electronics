package com.janhavi.dao;

import java.util.List;

import com.janhavi.model.Invoice;
import com.janhavi.model.Item;

public interface InvoiceDao{
	public String getCustomerid(int invoiceid);
	public String getPaymentMethod(int invoiceid);
	public String getDateOfIssue(int invoiceid);
	public List<Item> getOrder(final int invoiceid);
	public List<Invoice> getInvoice(final String customerid);
	public List<Invoice> getAllInvoices();
}