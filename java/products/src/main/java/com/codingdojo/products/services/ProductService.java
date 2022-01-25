package com.codingdojo.products.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.products.models.Category;
import com.codingdojo.products.models.Product;
import com.codingdojo.products.repositories.CategoryRepository;
import com.codingdojo.products.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	@Autowired 
	private CategoryRepository cRepo;
	
	//Get all
		public List<Product> getAllProducts(){
			return this.pRepo.findAll();
		}
		//Get one
		public Product getOneProduct(Long id) {
			return this.pRepo.findById(id).orElse(null);
		}
		//Create
		public Product createProduct(Product product) {
			return this.pRepo.save(product);
		}
		//Update
		public Product updateProduct(Product product) {
			return this.pRepo.save(product);
		}
		//Delete
		public void deleteProduct(Long id) {
			this.pRepo.deleteById(id);
		}
		public void addToProduct(Category category, Product product) {
			List<Product> existingProducts =category.getProducts();
			existingProducts.add(product);
			this.cRepo.save(category);
		}
}
