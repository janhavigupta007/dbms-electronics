package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.OrderDao;

@Controller
public class SubmitOrderController {

	@Autowired
	OrderDao orderDao;
	@RequestMapping(value = "/order/submit", method = RequestMethod.GET)
	public ModelAndView submitOrder() {
		ModelAndView m = new ModelAndView("order");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		int c = orderDao.placeOrder(userDetail.getUsername());
		if(c==0)
			m.addObject("msg","no new order placed");
		m.addObject("orders",orderDao.getOrders(userDetail.getUsername()));
		return m;
	}
	
	@RequestMapping(value = "/order/show", method = RequestMethod.GET)
	public ModelAndView showOrder() {
		ModelAndView m = new ModelAndView("order");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		m.addObject("orders",orderDao.getOrders(userDetail.getUsername()));
		return m;
	}
	
	@RequestMapping(value = "/vieworder")
	public ModelAndView showOrders() {
		ModelAndView m = new ModelAndView("order");
		m.addObject("orders",orderDao.getAllOrders());
		return m;
	}
}