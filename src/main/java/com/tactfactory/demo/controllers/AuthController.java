package com.tactfactory.demo.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.demo.services.RoleService;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping("")
public class AuthController {
	

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value = {"/", ""})
	public String index(final Model model) {
				
		if(userService.findAll().isEmpty()) {
			roleService.generateRoles();
			userService.generateUsers(10);	
		}
		
		model.addAttribute("users", this.userService.findAll());
		
		return "/auth/index";
	}
	
	@GetMapping(value = {"/login/{id}"})
	public String login(@PathVariable final long id, final HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.setAttribute("user_id", id);
		
		String result = "redirect:" + "/";
		
		if(userService.findById(id).getRole().getName() == "seller") {
			result =  "redirect:" + "/seller";
		} else if (userService.findById(id).getRole().getName() == "customer") {
			result = "redirect:" + "/customer";
		}
		
		return result;
		
	}
	
}
