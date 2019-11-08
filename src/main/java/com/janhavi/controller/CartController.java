package com.janhavi.controller;

import java.util.List;

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
import com.janhavi.dao.ProductDao;
import com.janhavi.model.Item;

@Controller
public class CartController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CartDao cartDao;
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public ModelAndView index() {
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			List<Item> cart = cartDao.getCart(userDetail.getUsername());
			if(cart.isEmpty()) {
				ModelAndView m = new ModelAndView("home");
				m.addObject("msg","No items in cart");
				return m;
			}
			else
			{	
				ModelAndView m = new ModelAndView("cart");
				m.addObject("cart",cartDao.getCart(userDetail.getUsername()));
				return m;
			}
	}

	@RequestMapping(value = "/cart/buy/{productid}", method = RequestMethod.GET)
	public ModelAndView buy(@PathVariable("productid") int productid) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ModelAndView m = new ModelAndView("product");
		m.addObject("products",productDao.findAll());
		cartDao.addToCart(userDetail.getUsername(), productid);
	    m.addObject("msg","Product added to the cart");
		return m;
	}
	
	@RequestMapping(value = "/cart/delete/{productid}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("productid") int productid) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ModelAndView m = new ModelAndView("cart");
		cartDao.deleteFromCart(userDetail.getUsername(), productid);
		m.addObject("cart",cartDao.getCart(userDetail.getUsername()));
	    m.addObject("msg","Product deleted from the cart");
		return m;
	}
}