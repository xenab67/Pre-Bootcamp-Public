package com.codingdojo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	@Autowired
	private ProductRepository pRepo;
	
	//Get all
		public List<Category> getAllCategories(){
			return this.cRepo.findAll();
		}
		//Get one
		public Category getOneCategory(Long id) {
			return this.cRepo.findById(id).orElse(null);
		}
		//Create
		public Category createCategory(Category category) {
			return this.cRepo.save(category);
		}
		//Update
		public Category updateCategory(Category category) {
			return this.cRepo.save(category);
		}
		//Delete
		public void deleteCategory(Long id) {
			this.cRepo.deleteById(id);
		}
		public void addToCategory(Product product, Category category) {
			List<Category> existingCategories =product.getCategories();
			existingCategories.add(category);
			this.pRepo.save(product);
		}
		
}
