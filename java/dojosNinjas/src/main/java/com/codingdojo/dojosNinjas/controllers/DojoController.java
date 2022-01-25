package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.models.Ninja;
import com.codingdojo.dojosNinjas.services.DojoService;
import com.codingdojo.dojosNinjas.services.NinjaService;


@Controller
public class DojoController {
	@Autowired
	private DojoService dService;
	@Autowired
	private NinjaService nService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Dojo> allDojos = this.dService.getAllDojos();
		viewModel.addAttribute("dojos",allDojos);
		return "index.jsp";
	}
	
	@GetMapping("/new/dojo")
	public String addDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "create.jsp";
	}
	@PostMapping("/new/dojo")
	public String newDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		}
		this.dService.createDojo(dojo);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editDojo(@PathVariable("id") Long id, @ModelAttribute("dojo") Dojo dojo, Model viewModel) {
		viewModel.addAttribute("dojo", this.dService.getOneDojo(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dojo", this.dService.getOneDojo(id));
			return"edit.jsp";
		}
		this.dService.updateDojo(dojo);
		return "redirect:/";
	}
	@GetMapping("/dojo/{id}")
	public String show(Model viewModel, @PathVariable("id") Long Id) {
		Dojo dojoToShow = this.dService.getOneDojo(Id);
		viewModel.addAttribute("dojo",dojoToShow);
		return "show.jsp";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.dService.deleteDojo(id);
		return "redirect:/";
	}
	@GetMapping("/new/ninja")
	public String addNinja(Model viewModel, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> allDojos=this.dService.getAllDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "createNinja.jsp";
	}
	@PostMapping("/new/ninja")
	public String newNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.dService.getAllDojos();
			viewModel.addAttribute("allDojos", allDojos);
			return "createNinja.jsp";
		}
		this.nService.createNinja(ninja);
		Long dojosId= ninja.getDojo().getId();
		return "redirect:/dojo/" + dojosId;
	}
}
