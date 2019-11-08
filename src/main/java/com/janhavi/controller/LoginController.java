package com.janhavi.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.UserDao;
import com.janhavi.model.User;


@Controller
public class LoginController {
	
	@Autowired
    private JavaMailSender mailSender;
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password OR User not verified");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	@RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgotpassword1() {
		ModelAndView m = new ModelAndView("forgotpassword");
		m.addObject("user",new User());
		return m;
	}

	@RequestMapping(value = "/forgotpassword", method = RequestMethod.POST)
	public ModelAndView forgotpassword(@ModelAttribute("user")User user) {

		ModelAndView m = new ModelAndView("login");
		String password = generateString();
		int c = userDao.updatePassword(user.getUsername(), password);
		if(c>0) {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo(userDao.getEmail(user.getUsername()));
			email.setSubject("Password Reset");
			email.setText("Your new password is"+password);
			mailSender.send(email);
			m.addObject("mesg","Reset Mail sent");
		}
		else
		{
			m.addObject("mesg","Couldn't update password! Try again");
		}
		return m;
	}

	@RequestMapping(value = "/confirmotp", method = RequestMethod.GET)
	public ModelAndView confirmotp() {
		ModelAndView m = new ModelAndView("otp");
		return m;
	}
	
	@RequestMapping(value = "/confirmotp", method = RequestMethod.POST)
	public ModelAndView confirmotp1(@RequestParam("username")String username, 
			@RequestParam("otp")String otp) {
		ModelAndView m = new ModelAndView("login");
		if(userDao.getUsername(otp)!= null && userDao.getUsername(otp).equalsIgnoreCase(username)) {
			userDao.deleteOtp(otp);
			userDao.setEnabled(username);
			m.addObject("mesg","OTP confirmed");
		}
		else {
		m.addObject("mesg","Couldn't verify! Try again");
		}
		return m;
	}


	private String generateString() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

}