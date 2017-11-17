package com.oes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oes.model.User;

@Controller
public class MainController {

	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(value = "/index.html", method=RequestMethod.GET)
	public String getIndexPageOnRequest() {
		return "index";
	}
	
	
	@RequestMapping(value = "/signUp.html", method=RequestMethod.GET)
	public String getSignUpPageForUser(Model model) {
		model.addAttribute("user", new User());
		return "userSignUp";
	}
	
	@RequestMapping(value = "/signOut.html", method=RequestMethod.GET)
	public String getSignOutPageForUser() {
		return "userSignOut";
	}
	
}
