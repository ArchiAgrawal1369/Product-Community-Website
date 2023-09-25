package com.nagaro.ExitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagaro.ExitTest.model.*;
import com.nagaro.ExitTest.repo.*;
import com.nagaro.ExitTest.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	private ProductService service;

	@Autowired
	private ProductRepo repo;
	
	
	//********************* SEARCH API ******************************************
	
	//Get the list of all products 
	@GetMapping("/product")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> getProducts()
	{		return repo.findAll();
	}
	
	//Search product by code or name or brand
	@GetMapping("/search/{productCode}")
	@CrossOrigin(origins="http://localhost:4200")
	public List<Product> productById(@PathVariable String productCode) throws Exception{
		List<Product> product;
		product= repo.findByProductCodeOrProductNameContainingOrProductBrandContaining(productCode, productCode, productCode);
		if(product.isEmpty()) {
			throw new Exception("Product doesn't exist!");
		}
		return product;
	}
	
	//Get product Details product by code 
	@GetMapping("/details/{productCode}")
	@CrossOrigin(origins="http://localhost:4200")
	public Product productDetails(@PathVariable String productCode){
		Product prodObj = service.fetchProductByProductCode(productCode);
		return prodObj;
	}	
	
	//View ratings of reviews by product id
	@GetMapping("/rating/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public String getRatingsbyId(@PathVariable String id) {
		Product product = service.fetchProductByProductCode(id);
		List<ProductReviews> reviews = product.getReview();
		if (!reviews.isEmpty()) {
			double totalRating = 0.0;
			for (ProductReviews review : reviews) {
				totalRating += Double.parseDouble(review.getRatings());;
			}
			double averageRating = (double) totalRating / reviews.size();
            String formattedRating = String.format("%.2f",averageRating );
			
			return formattedRating;
		}
		return "0.00";
	}
	
	
	//********************* STATISTICS API **************************************
	
	//Get the number of Products
	@GetMapping("/count-products")
	@CrossOrigin(origins="http://localhost:4200")
	public Long getProductCount()
	{
		return this.service.getNumberofProducts();
	}
}
