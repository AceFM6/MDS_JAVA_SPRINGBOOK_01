package com.tactfactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.demo.services.BookService;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	private BookService bookService;

	@GetMapping(value = {"/", ""})
	public String index(final Model model) {
		
		model.addAttribute("books", bookService.findAll());
		
		return "/customer/index";
	}
	
	
	
}
