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
public class Products {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		return "index.jsp";
	}
	@GetMapping("/products")
	public String showProducts(Model viewModel) {
		List<Product> allProducts=this.pService.getAllProducts();
		viewModel.addAttribute("products", allProducts);
		return "allProducts.jsp";
	}
	@GetMapping("/new/product")
	public String addProduct(Model viewModel,@ModelAttribute("product")Product product) {
		List<Category> allCategories=this.cService.getAllCategories();
		viewModel.addAttribute("allCategories",allCategories);
		return "createProduct.jsp";
	}
	@PostMapping("/new/product")
	public String newProduct(@Valid @ModelAttribute("product")Product product, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			List<Category> allCategories=this.cService.getAllCategories();
			viewModel.addAttribute("allCategories",allCategories);
			return "createProduct.jsp";
		}
		this.pService.createProduct(product);
		return "redirect:/";
	}
	@GetMapping("/edit/product/{id}")
	public String editProduct(@PathVariable("id")Long id, @ModelAttribute("product")Product product, Model viewModel) {
		viewModel.addAttribute("product",this.pService.getOneProduct(id));
		return "editProduct.jsp";
	}
	@PostMapping("/edit/product/{id}")
	public String editProduct(@Valid @ModelAttribute("product")Product product,BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("product", this.pService.getOneProduct(id));
			return "editProduct.jsp";		
			}
		this.pService.updateProduct(product);
		return "redirect:/";
	}
	@GetMapping("/product/{id}")
	public String show(Model viewModel, @PathVariable("id") Long Id) {
		Product productToShow = this.pService.getOneProduct(Id);
		viewModel.addAttribute("product",productToShow);
		List<Category> allCategories=this.cService.getAllCategories();
		viewModel.addAttribute("allCategories",allCategories);
		return "showProduct.jsp";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.pService.deleteProduct(id);
		return "redirect:/";
	}
	@PostMapping("/add/category/{id}")
	public String addToCategory(@RequestParam(name="category") Long id, @PathVariable("id")Long productId) {
		Product productAddCategory=this.pService.getOneProduct(productId);
		Category categoryToAdd= this.cService.getOneCategory(id);
		this.pService.addToProduct(categoryToAdd, productAddCategory);
		return "redirect:/";
	}
}
