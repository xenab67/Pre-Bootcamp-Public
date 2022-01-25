package com.codingdojo.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.products.models.Product;
import com.codingdojo.products.services.ProductService;

@RestController
@RequestMapping("API")
public class APIProductsController {
	@Autowired
	private ProductService pService;
	
	@GetMapping("")
	public List<Product>index(){
		return this.pService.getAllProducts();
	}
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id")Long id) {
		return this.pService.getOneProduct(id);
	}
	@PostMapping("/new")
	public Product create(Product product) {
		return this.pService.createProduct(product);
	}
	@DeleteMapping("/update/{id}")
	public Product updateProduct(@PathVariable("id")Long id, Product updateProduct) {
		return this.pService.updateProduct(updateProduct);
	}
}
