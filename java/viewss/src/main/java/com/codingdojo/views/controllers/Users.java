package com.codingdojo.views.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.views.models.User;
import com.codingdojo.views.services.UserService;

// imports removed for brevity
@Controller
public class Users {
	private final UserService userService;
    
    public Users(UserService userService) {
        this.userService = userService;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
		return "registrationPage.jsp";
		}
	User newUser= this.userService.registerUser(user);
	session.setAttribute("user__id", newUser.getId());
	return "redirect:/home";	
	}
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes redirectAttrs) {
    	if(!this.userService.authenticateUser(email, password)) {
    			redirectAttrs.addFlashAttribute("loginError", "Invalid Login");
    			return "redirect:/";
    		}
    		User user = this.userService.findByEmail(email);
    		session.setAttribute("user__id", user.getId());
    		return "redirect:/home";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model viewModel) {
    	if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.userService.findUserById((Long)session.getAttribute("user__id")));
		return "homePage.jsp";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
		return "redirect:/";
    }
}