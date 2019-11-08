package com.janhavi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.janhavi.dao.ProductDao;
import com.janhavi.model.Category;
import com.janhavi.model.Product;

@Controller
public class ProductController{
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView products() {
		ModelAndView m = new ModelAndView("product");
		m.addObject("products", productDao.findAll());
		return m;
	}
	
	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView addProducts() {
		ModelAndView m = new ModelAndView("addProduct");
		m.addObject("product", new Product());
		return m;
	}
	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public ModelAndView addProducts(@ModelAttribute("product") Product product,
            BindingResult result) {

		ModelAndView mv = new ModelAndView("addProduct");
		//mv.addObject("products", productDao.findAll());

		int counter = productDao.addProduct(product);

		if (counter > 0) {
			mv.addObject("msg", "Product added.");
		}
		else {
			mv.addObject("msg", "Error (Check if the category exists)");
		}
		return mv;
	}
	
	@RequestMapping(value = "/product/addCategory", method = RequestMethod.GET)
	public ModelAndView addCategory() {
		ModelAndView m = new ModelAndView("addCategory");
		m.addObject("category", new Category());
		return m;
	}
	
	@RequestMapping(value = "/product/addCategory", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("category") Category category,
            BindingResult result) {

		ModelAndView mv = new ModelAndView("addCategory");
		//mv.addObject("products", productDao.findAll());

		int counter = productDao.addCategory(category);

		if (counter > 0) {
			mv.addObject("msg", "Category added.");
		}
		else {
			mv.addObject("msg", "Category already exists");
		}

		return mv;

	}
	
}