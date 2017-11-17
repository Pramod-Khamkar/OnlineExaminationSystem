package com.oes.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oes.dto.AdminDTO;
import com.oes.model.Admin;
import com.oes.service.AdminService;

@Controller
@SessionAttributes("adminDetails")
public class AdminLoginController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/adminSignIn.html", method = RequestMethod.GET)
	public String getSignInPageForAdmin() {
		return "adminSignIn";
	}

	@RequestMapping(value = "/adminSignUp.html", method = RequestMethod.GET)
	public String getSignUpPageForAdmin(Model model) {
		model.addAttribute("admin", new Admin());
		return "adminSignUp";
	}

	@RequestMapping(value = "/registerAdmin.html", method = RequestMethod.POST)
	public String registerAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "adminSignUp";
		} else {
			model.addAttribute("admin", admin);
			AdminDTO adminDTO = new AdminDTO();
			adminDTO.setFirstName(admin.getFirstName());
			adminDTO.setLastName(admin.getLastName());
			adminDTO.setMailId(admin.getMailId());
			adminDTO.setPassword(admin.getPassword());

			Boolean flag = adminService.registerAdmin(adminDTO);

			if (flag == true) {
				model.addAttribute("message", "Credentials : Use MailId as Username and Password as Password");
				return "adminSignIn";
			} else {
				model.addAttribute("message", "Registration Failed...");
				return "adminSignUp";
			}
		}
	}

	@RequestMapping(value = "/loginAdmin.html", method = RequestMethod.POST)
	public String authenticateadmin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session,RedirectAttributes redirectAttributes) {

		AdminDTO adminDTO = new AdminDTO();
		adminDTO.setMailId(username);
		adminDTO.setPassword(password);
		AdminDTO fetchedData = adminService.authenticateAdmin(adminDTO);
		if (fetchedData != null) {
			model.addAttribute("adminDetails", fetchedData);
			//session.setAttribute("adminDetails", fetchedData);
			redirectAttributes.addFlashAttribute("adminDetails", fetchedData);
			return "redirect:/showCategoryToAdmin.html";
		} else {
			model.addAttribute("message", "username Or Password not valid....");
			return "adminSignIn";
		}
	}
	
	@RequestMapping(value="/logOutAdmin.html",method=RequestMethod.GET)
	public String logOutUser(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.html";
	}

}
