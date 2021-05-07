package com.tactfactory.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping("/seller")
public class SellerController {
	
	protected static final String REDIRECT_INDEX = "/seller";
    protected final String REDIRECT_CREATE = "/seller/create";
    
	@Autowired
	private UserService userService;
	
	@GetMapping(value = {"/", ""})
	public String index(final Model model, final HttpServletRequest request, final RedirectAttributes attributes) {
				
		HttpSession session = request.getSession();
		long user_id = (long) session.getAttribute("user_id");
		User user = this.userService.findById(user_id);
		
		if(user != null) {
			model.addAttribute("books", user.getBooks());
		} else {
			if (attributes.getFlashAttributes().containsKey("erreurs")) {
	            model.addAttribute("erreurs", attributes.getFlashAttributes().get("erreurs"));
	        }
		}
				
		return "/seller/index";
	}
	
	@GetMapping(value = {"/create"})
	public String createBook(final Model model, final HttpServletRequest request) {
				
		return "/book/create";
	}
	
	@PostMapping(value = {"/create"})
	public String createBookPost(final Model model, final RedirectAttributes attributes, final HttpServletRequest request, final Book book) {
		String result = SellerController.REDIRECT_INDEX;
		
		HttpSession session = request.getSession();
		long user_id = (long) session.getAttribute("user_id");
		
		User user = userService.findById(user_id);
		
		if(user != null) {
			user.getBooks().add(book);
		} else {
			model.addAttribute("erreurs", attributes.getFlashAttributes().get("erreurs"));
			result = this.REDIRECT_CREATE;
		}
		
		return result;
	}
	
}
