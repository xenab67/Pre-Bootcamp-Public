package com.codingdojo.greatIdeas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.greatIdeas.models.Idea;
import com.codingdojo.greatIdeas.models.User;
import com.codingdojo.greatIdeas.services.IdeaService;
import com.codingdojo.greatIdeas.services.UserService;

@Controller
public class IdeaController {
	@Autowired
	private IdeaService iService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/ideas")
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		viewModel.addAttribute("allIdeas", this.iService.getAllIdeas());
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		return "ideas.jsp";
	}
	@GetMapping("/new")
	public String addIdea(@ModelAttribute("idea")Idea idea) {
		return "newIdea.jsp";
	}
	@PostMapping("/new")
	public String newIdea(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, HttpSession session) {
		User user =this.uService.getOneUser((Long)session.getAttribute("user__id"));
		idea.setOwner(user);
		if(result.hasErrors()) {
			return "newIdea.jsp";
		}
		this.iService.createIdea(idea);
		return "redirect:/ideas";
	}
	@GetMapping("/edit/{id}")
	public String editIdea(@PathVariable("id")Long id,@ModelAttribute("idea")Idea idea, Model viewModel) {
		viewModel.addAttribute("idea", this.iService.getOneIdea(id));
		return"edit.jsp";
	}
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		User user =this.uService.getOneUser((Long)session.getAttribute("user__id"));
		idea.setOwner(user);
		if(result.hasErrors()) {
			return "edit.jsp";
	}
		this.iService.editIdea(idea);
		return "redirect:/ideas";
}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id")Long id, Model viewModel) {
		viewModel.addAttribute("showIdea", this.iService.getOneIdea(id));
		return "show.jsp";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.iService.deleteIdea(id);
		return "redirect:/ideas";
	}
	
}