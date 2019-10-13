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

import com.janhavi.dao.CartDao;
import com.janhavi.dao.InvoiceDao;


@Controller
public class InvoiceController {

	@Autowired
	CartDao cartDao;
	@Autowired
	InvoiceDao invoiceDao;
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout() {
		ModelAndView m = new ModelAndView("temporaryinvoice");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		m.addObject("Customerid",userDetail.getUsername());
		m.addObject("cart",cartDao.getCart(userDetail.getUsername()));
		return m;
	}
	
	@RequestMapping(value = "/invoice/{invoiceid}", method = RequestMethod.GET)
	public ModelAndView invoice(@PathVariable("invoiceid")int invoiceid) {
		ModelAndView m = new ModelAndView("invoice");
		m.addObject("orderid",invoiceid);
		m.addObject("customerid",invoiceDao.getCustomerid(invoiceid));
		m.addObject("order",invoiceDao.getOrder(invoiceid));
		m.addObject("date",invoiceDao.getDateOfIssue(invoiceid));
		m.addObject("paymentmethod",invoiceDao.getPaymentMethod(invoiceid));
		return m;
	}
	
}