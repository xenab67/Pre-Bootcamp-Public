package com.codingdojo.dojosNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.dojosNinjas.models.Dojo;
import com.codingdojo.dojosNinjas.services.DojoService;


@RestController
@RequestMapping("/API")
public class APIDojosController {
	@Autowired
	private DojoService dService;
	
	@GetMapping("")
	public List<Dojo> index(){
		return this.dService.getAllDojos();
	}
	
	@GetMapping("/{id}")
	public Dojo getDojo(@PathVariable("id")Long id) {
		return this.dService.getOneDojo(id);
	}
	
	@PostMapping("/new")
	public Dojo create(Dojo dojo) {
		return this.dService.createDojo(dojo);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteDojo(@PathVariable("id")Long id) {
		this.dService.deleteDojo(id);
	}
	
	@PutMapping("/update/{id}")
	public Dojo updateLanguage(@PathVariable("id")Long id, Dojo updateDojo) {
		return this.dService.updateDojo(updateDojo);
	}
}
