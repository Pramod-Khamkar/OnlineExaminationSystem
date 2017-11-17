package com.oes.controller;

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

import com.oes.dto.UserDTO;
import com.oes.model.User;
import com.oes.service.UserService;

@Controller
@SessionAttributes("userDetails")
public class UserLoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userSignIn.html", method = RequestMethod.GET)
	public String getSignInPageForUser() {
		return "userSignIn";
	}

	@RequestMapping(value = "/userSignUp.html", method = RequestMethod.GET)
	public String getSignUpPageForUser(Model model) {
		model.addAttribute("user", new User());
		return "userSignUp";
	}

	@RequestMapping(value = "/registerUser.html", method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "userSignUp";
		} else {
			model.addAttribute("user", user);
			System.out.println(user);

			UserDTO userDTO = new UserDTO();
			userDTO.setFirstName(user.getFirstName());
			userDTO.setLastName(user.getLastName());
			userDTO.setAge(user.getAge());
			userDTO.setDateOfBirth(user.getDateOfBirth());
			userDTO.setGender(user.getGender());
			userDTO.setGraduationCollageName(user.getGraduationCollageName());
			userDTO.setMailId(user.getMailId());
			userDTO.setPassword(user.getPassword());
			userDTO.setMarks_ssc(user.getMarks_ssc());
			userDTO.setMarks_hsc(user.getMarks_hsc());
			userDTO.setPostGraduationCollageName(user.getPostGraduationCollageName());
			userDTO.setPhone(user.getPhone());
			userDTO.setMarks_graduation(user.getMarks_graduation());
			userDTO.setMarks_postgraduation(user.getMarks_postgraduation());

			Boolean flag = userService.registerUser(userDTO);

			if (flag == true) {
				model.addAttribute("message", "Credentials : Use MailId as Username and Password as Password");
				return "userSignIn";
			} else {
				model.addAttribute("message", "Registration Failed...");
				return "userSignUp";
			}
		}
	}

	@RequestMapping(value = "/loginUser.html", method = RequestMethod.POST)
	public String authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model,RedirectAttributes redirectAttributes) {

		UserDTO userDTO = new UserDTO();
		userDTO.setMailId(username);
		userDTO.setPassword(password);
		UserDTO fetchedData = userService.authenticateUser(userDTO);
		if (fetchedData != null) {
			model.addAttribute("userDetails", fetchedData);
			redirectAttributes.addFlashAttribute("userDetails", fetchedData);
			return "redirect:/showCategoryAfterLogin.html";
		} else {
			model.addAttribute("message", "Username Or Password not valid....");
			return "userSignIn";
		}
	}
	
	@RequestMapping(value="/logOutUser.html",method=RequestMethod.GET)
	public String logOutUser(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index.html";
	}
	
	@RequestMapping(value="/500",method=RequestMethod.GET)
	public String errorPage500() {
		return "redirect:/index.html";
	}
}
