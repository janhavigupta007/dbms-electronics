package com.janhavi.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.UserDao;
import com.janhavi.model.User;

@Controller
public class RegistrationController {

	@Autowired
	private UserDao userDao;
	@Autowired
    private JavaMailSender mailSender;

	@RequestMapping(value="/register", method = RequestMethod.GET) 
	public ModelAndView userRegistration() {
		ModelAndView m = new ModelAndView("registration");
		m.addObject("user",new User());
		return m;
	}
	
	@RequestMapping(value = "/register",params="Customer", method = RequestMethod.POST)
	public ModelAndView userRegistration1(@ModelAttribute("user") User user,
            BindingResult result) {

		ModelAndView mv = new ModelAndView("registration");

		int counter = userDao.registerCustomer(user);
		String otp = generateRandomotp();
		userDao.addEntryOtp(user.getUsername(), otp);
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(userDao.getEmail(user.getUsername()));
	    email.setSubject("Confirm your otp");
	    email.setText("Your OTP is "+otp);
	    mailSender.send(email);
		if (counter > 0) {
			mv.addObject("msg", "Customer registration successful. Please confirm your otp");
		}
		else {
			mv.addObject("msg", "UserId already exists.");
		}
		return mv;

	}
	@RequestMapping(value = "/register",params="Partner", method = RequestMethod.POST)
	public ModelAndView userRegistration2(@ModelAttribute("user") User user,
			BindingResult result) {

		ModelAndView mv = new ModelAndView("registration");
		int counter = userDao.registerPartner(user);
		String otp = generateRandomotp();
		userDao.addEntryOtp(user.getUsername(), otp);
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(userDao.getEmail(user.getUsername()));
	    email.setSubject("Confirm your otp");
	    email.setText("Your OTP is "+otp);
	    mailSender.send(email);

		if (counter > 0) {
			mv.addObject("msg", "Partner registration successful. Please confirm your otp");
		}
		else {
			mv.addObject("msg", "UserId already exists.");
		}
		return mv;
	}

	
	
	private String generateRandomotp() {
		 String otp = RandomStringUtils.randomAlphanumeric(10);
		 while(userDao.getUsername(otp)!= null) {
			 otp = RandomStringUtils.randomAlphanumeric(10);
		 }
		 return otp;
	}
}