package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APILanguageController {
	@Autowired
	private LanguageService lService;
	
	@GetMapping("")
	public List<Language> index(){
		return this.lService.getAllLanguages();
	}
	
	@GetMapping("/{id}")
	public Language getLanguage(@PathVariable("id")Long id) {
		return this.lService.getOneLanguage(id);
	}
	
	@PostMapping("/create")
	public Language create(Language language) {
		return this.lService.createLanguage(language);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteLanguage(@PathVariable("id")Long id) {
		this.lService.deleteLanguage(id);
	}
	
	@PutMapping("/update/{id}")
	public Language updateLanguage(@PathVariable("id")Long id, Language updateLanguage) {
		return this.lService.updateLanguage(updateLanguage);
	}
}
