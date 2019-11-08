package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.InvoiceDao;
import com.janhavi.dao.OrderDao;

@Controller
public class SubmitOrderController {

	@Autowired
	OrderDao orderDao;
	@Autowired
	InvoiceDao invoiceDao;
	@RequestMapping(value = "/order/submit")
	public ModelAndView submitOrder() {
		ModelAndView m = new ModelAndView("orders");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		int c = orderDao.placeOrder(userDetail.getUsername());
		if(c==0)
			m.addObject("msg","No new order placed");
		m.addObject("invoice",invoiceDao.getInvoice(userDetail.getUsername()));
		return m;
	}
	
	@RequestMapping(value = "/order/show")
	public ModelAndView showOrder() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		if(invoiceDao.getInvoice(userDetail.getUsername()).isEmpty()) {
			ModelAndView m = new ModelAndView("home");
			m.addObject("msg","No orders to display");
			return m;
		}
		ModelAndView m = new ModelAndView("orders");
		m.addObject("invoice",invoiceDao.getInvoice(userDetail.getUsername()));
		return m;
	}
	@RequestMapping(value = "/orderdetails/{invoiceid}", method =RequestMethod.GET)
	public ModelAndView showOrder(@PathVariable("invoiceid")int invoiceid) {
		ModelAndView m = new ModelAndView("orderdetails");
		m.addObject("orderid",invoiceid);
		m.addObject("orders",orderDao.getOrder(invoiceid));
		return m;
	}
	
	@RequestMapping(value = "/vieworder")
	public ModelAndView showOrders() {
		if(invoiceDao.getAllInvoices().isEmpty()) {
			ModelAndView m = new ModelAndView("home");
			m.addObject("msg","No orders to display");
			return m;
		}
		ModelAndView m = new ModelAndView("orders");
		m.addObject("invoice",invoiceDao.getAllInvoices());
		return m;
	}
}