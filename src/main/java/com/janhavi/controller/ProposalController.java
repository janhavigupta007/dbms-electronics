package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.ProposalDao;
import com.janhavi.dao.UserDao;

@Controller
public class ProposalController{
	
	@Autowired
	ProposalDao proposalDao;
	@Autowired
	UserDao userDao;
	@Autowired
    private JavaMailSender mailSender;
	
	@RequestMapping(value = "/proposal/{productid}", method = RequestMethod.GET)
	public ModelAndView proposal(@PathVariable("productid")int productid) {
		ModelAndView m = new ModelAndView("proposal");
		m.addObject("proposals",proposalDao.getPendingproposals(productid));
		m.addObject("productid",productid);
		return m;
	}
	
	@RequestMapping(value = "/proposal/{productid}/{partner}", method = RequestMethod.GET)
	public ModelAndView acceptProposal(@PathVariable("productid")int productid,
			@PathVariable("partner")String partnerid) {
		ModelAndView m = new ModelAndView("proposal");
		int c = proposalDao.updateStatus(productid, partnerid);
		SimpleMailMessage email = new SimpleMailMessage();
	    email.setTo(userDao.getEmail(partnerid));
	    email.setSubject("Acceptance mail");
	    email.setText("Your proposal for product "+productid+" is accepted.");
	    mailSender.send(email);
		if(c>0) {
			m.addObject("msg","Acceptance mail sent");
		}
		else
		{
			m.addObject("msg","Couldn't accept proposal! Try again");
		}
		m.addObject("proposals",proposalDao.getPendingproposals(productid));
		m.addObject("productid",productid);
		return m;
	}
}