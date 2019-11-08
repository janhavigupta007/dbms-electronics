package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.UserDao;
import com.janhavi.model.Feedback;

@Controller
public class HomeController {
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	UserDao userDao;
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	@RequestMapping("/welcome")
	public ModelAndView welcome() {
		ModelAndView model = new ModelAndView("welcome");
		//model.addObject("msg", "Welcome user");
		return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {
		ModelAndView model = new ModelAndView();	
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
			model.addObject("username", userDetail.getUsername());	
		}
		model.setViewName("error");
		return model;
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public ModelAndView feedback() {
		ModelAndView model = new ModelAndView("feedback");
		model.addObject("feedback", new Feedback());
		return model;
	}
	
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	public ModelAndView feedback(@ModelAttribute("feedback")Feedback feedback) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		ModelAndView model = new ModelAndView("home");
		userDao.feedback(userDetail.getUsername(), feedback);
		model.addObject("msg","Feedback added successfully\n Thanks for rating!!!");
		return model;
	}
	
	@RequestMapping(value = "/viewfeedback")
	public ModelAndView feedbacks() {
		if(userDao.getFeedbacks().isEmpty()) {
			ModelAndView model = new ModelAndView("home");
			model.addObject("msg","No feedbacks to display");
			return model;
		}
		ModelAndView model = new ModelAndView("viewfeedback");
		model.addObject("feedbacks",userDao.getFeedbacks());
		return model;
	}
}
