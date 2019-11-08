package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.ProductDao;
import com.janhavi.dao.ProposalDao;
import com.janhavi.dao.UserDao;

@Controller
public class ProposalController{
	
	@Autowired
	ProductDao productDao;
	@Autowired
	ProposalDao proposalDao;
	@Autowired
	UserDao userDao;
	@Autowired
    private JavaMailSender mailSender;
	
	@RequestMapping(value = "/proposal/{productid}", method = RequestMethod.GET)
	public ModelAndView proposal(@PathVariable("productid")int productid) {
		if(proposalDao.getPendingproposals(productid).isEmpty()) {
			ModelAndView m = new ModelAndView("home");
			m.addObject("msg","No pending proposals for product: "+productid);
			return m;
		}
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
		
		if(c>0) {
			SimpleMailMessage email = new SimpleMailMessage();
		    email.setTo(userDao.getEmail(partnerid));
		    email.setSubject("Acceptance mail");
		    email.setText("Your proposal for product "+productid+" is accepted.");
		    mailSender.send(email);
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
	
	@RequestMapping(value = "/product/proposal", method = RequestMethod.GET)
	public ModelAndView addProposal() {

		ModelAndView mv = new ModelAndView("addProposal");
		return mv;

	}
	
	@RequestMapping(value = "/product/proposal", method = RequestMethod.POST)
	public ModelAndView addProposal(@RequestParam("productid") int productid,
            @RequestParam("price") int price) {

		ModelAndView mv = new ModelAndView("addProposal");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		int counter = productDao.addProposal(userDetail.getUsername(),productid, price);

		if (counter > 0) {
			mv.addObject("msg", "Proposal added.");
		}
		else if(counter==-1){
			mv.addObject("msg", " Proposal already exists");
		}
		else if(counter==-2) {
			mv.addObject("msg", " No such product exists");
		}

		return mv;

	}
}