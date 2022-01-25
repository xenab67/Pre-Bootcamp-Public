package com.codingdojo.languages.controllers;

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

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Language> allLanguages = this.lService.getAllLanguages();
		viewModel.addAttribute("languages",allLanguages);
		return "index.jsp";
	}
	
	@GetMapping("/new")
	public String addLanguage(@ModelAttribute("language")Language language) {
		return "create.jsp";
	}
	@PostMapping("/new")
	public String newLanguage(@Valid @ModelAttribute("language")Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "create.jsp";
		}
		this.lService.createLanguage(language);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, @ModelAttribute("languauge") Language language, Model viewModel) {
		viewModel.addAttribute("language", this.lService.getOneLanguage(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("language", this.lService.getOneLanguage(id));
			return"edit.jsp";
		}
		this.lService.updateLanguage(language);
		return "redirect:/";
	}
	@GetMapping("/language/{id}")
	public String show(Model viewModel, @PathVariable("id") Long Id) {
		Language languageToShow = this.lService.getOneLanguage(Id);
		viewModel.addAttribute("language",languageToShow);
		return "show.jsp";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/";
	}
}

