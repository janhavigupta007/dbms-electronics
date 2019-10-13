package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.UserDao;
import com.janhavi.model.Customer;
import com.janhavi.model.Partner;

@Controller
public class ProfileController{
	
	@Autowired
	private UserDao userDao;
	
	@RequestMapping(value = "/profileCustomer", method = RequestMethod.GET)
	public ModelAndView profileCustomer() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Customer customer = userDao.getCustomer(userDetail.getUsername());
		ModelAndView m = new ModelAndView("profileCustomer");
		m.addObject("customer", customer);
		return m;
	}
	
	@RequestMapping(value = "/profileCustomer", method = RequestMethod.POST)
	public ModelAndView profileCustomer(@ModelAttribute("customer")Customer customer) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		userDao.updateCustomer(userDetail.getUsername(), customer);
		ModelAndView m = new ModelAndView("welcome");
		m.addObject("msg","Profile updated");
		return m;
	}
	
	@RequestMapping(value = "/profilePartner", method = RequestMethod.GET)
	public ModelAndView profilePartner() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		Partner partner = userDao.getPartner(userDetail.getUsername());
		ModelAndView m = new ModelAndView("profilePartner");
		m.addObject("partner", partner);
		return m;
	}
	
	@RequestMapping(value = "/profilePartner", method = RequestMethod.POST)
	public ModelAndView profilePartner(@ModelAttribute("partner")Partner partner) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		userDao.updatePartner(userDetail.getUsername(), partner);
		ModelAndView m = new ModelAndView("welcome");
		m.addObject("msg","Profile updated");
		return m;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public ModelAndView changepassword() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ModelAndView m = new ModelAndView("changepassword");
		m.addObject("username", userDetail.getUsername());
		return m;
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public ModelAndView changepassword(@RequestParam("oldpassword")String oldpassword, 
			@RequestParam("newpassword")String newpassword, 
			@RequestParam("confirmpassword")String confirmpassword) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ModelAndView m = new ModelAndView("welcome");
		if(userDao.getPassword(userDetail.getUsername()).equalsIgnoreCase(oldpassword)
				&& newpassword.equalsIgnoreCase(confirmpassword)) {
			userDao.updatePassword(userDetail.getUsername(), newpassword);
			m.addObject("msg","Password changed successfully");
		}
		else {
			m.addObject("msg","Couldn't change password");
		}
		return m;
	}
}
	