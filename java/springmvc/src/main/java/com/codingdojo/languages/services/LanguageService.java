package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo= repo;
	}
	//Get all
	public List<Language> getAllLanguages(){
		return this.lRepo.findAll();
	}
	//Get one
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Create
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
	//Update
	public Language updateLanguage(Language language) {
		return this.lRepo.save(language);
	}
	//Delete
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	//HTML forms
	public Language createLanguageHTML(String name, String creator, int version) {
		Language newLanguage = new Language(name, creator, version);
		return this.lRepo.save(newLanguage);
	}
}
