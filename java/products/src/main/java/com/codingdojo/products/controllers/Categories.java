package com.codingdojo.products.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.CategoryService;
import com.codingdojo.products.services.ProductService;

@Controller
public class Categories {
	
	@Autowired
	private CategoryService cService;

	@Autowired
	private ProductService pService;
	
	@GetMapping("/categories")
	public String showCategories(Model viewModel) {
		List<Category> allCategories=this.cService.getAllCategories();
		viewModel.addAttribute("categories", allCategories);
		return "showCategories.jsp";
	}
	@GetMapping("/new/category")
	public String addCategory(@ModelAttribute("category")Category category) {
		return "createCategory.jsp";
	}
	@PostMapping("/new/category")
	public String newCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "createCategory.jsp";
		}
		this.cService.createCategory(category);
		return "redirect:/";
	}
	@GetMapping("/category/{id}")
	public String show(Model viewModel, @PathVariable("id") Long Id) {
		Category categoryToShow = this.cService.getOneCategory(Id);
		viewModel.addAttribute("category",categoryToShow);
		List<Product> allProducts=this.pService.getAllProducts();
		viewModel.addAttribute("allProducts",allProducts);
		return "showOne.jsp";
}
	@PostMapping("/add/product/{id}")
	public String addToProduct(@RequestParam(name="product") Long id, @PathVariable("id")Long categoryId) {
		Category categoryToAdd= this.cService.getOneCategory(categoryId);
		Product productAddCategory=this.pService.getOneProduct(id);
		this.cService.addToCategory(productAddCategory, categoryToAdd);
		return "redirect:/";
	}
	
}