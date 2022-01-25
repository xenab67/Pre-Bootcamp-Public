package com.codingdojo.greatIdeas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.greatIdeas.models.Idea;
import com.codingdojo.greatIdeas.services.IdeaService;

@RestController
@RequestMapping("/API")
public class APIController {
	@Autowired
	private IdeaService iService;
	
	@GetMapping("/")
	public List<Idea> index(){
		return this.iService.getAllIdeas();
	}
	@GetMapping("/{id}")
	public Idea getOne(@PathVariable("id") Long id) {
		return this.iService.getOneIdea(id);
	}
	@PostMapping("/new")
	public Idea create(Idea idea) {
		return this.iService.createIdea(idea);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteIdea(@PathVariable("id")Long id) {
		this.iService.deleteIdea(id);
	}
	
	@PutMapping("/update/{id}")
	public Idea updateIdea(@PathVariable("id")Long id,Idea updateIdea) {
		return this.iService.editIdea(updateIdea);
	}
}
