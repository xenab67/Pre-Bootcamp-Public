package com.codingdojo.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.services.CategoryService;

public class APICateogryController {
	@Autowired
	private CategoryService cService;
	
	@GetMapping("")
	public List<Category>index(){
		return this.cService.getAllCategories();
	}
	@GetMapping("/{id}")
	public Category getCategory(@PathVariable("id")Long id) {
		return this.cService.getOneCategory(id);
	}
	@PostMapping("/new")
	public Category create(Category category) {
		return this.cService.createCategory(category);
	}
	@DeleteMapping("/update/{id}")
	public Category updateCategory(@PathVariable("id")Long id, Category updateCategory) {
		return this.cService.updateCategory(updateCategory);
	}
}
