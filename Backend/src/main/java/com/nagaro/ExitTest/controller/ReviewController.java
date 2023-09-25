package com.nagaro.ExitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagaro.ExitTest.model.Product;
import com.nagaro.ExitTest.model.ProductReviews;
import com.nagaro.ExitTest.service.ProductService;
import com.nagaro.ExitTest.service.ReviewService;

@RestController
public class ReviewController {
	
	@Autowired 
	private ReviewService service;
	
	
	//********************* REVIEWS API ****************************************
	
	//Add reviews by product code as id
	@PostMapping("/review/{id}")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity addReview(@RequestBody ProductReviews review, @PathVariable("id") String id) {
		service.addReviews(review, id);
		return ResponseEntity.status(200).build();
	}
	
	//View approved reviews by product code as id
		@GetMapping("/review/{id}")
		@CrossOrigin(origins="http://localhost:4200")
		public List<ProductReviews> getApprovedReviews(@PathVariable("id") String id) {
			List<ProductReviews> list = this.service.getApprovedReview(id);
			return list;
		}
	
		
	//********************* STATISTICS API ****************************************
	
		//Get the number of Products
		@GetMapping("/count-reviews")
		@CrossOrigin(origins="http://localhost:4200")
		public Long getProductCount()
		{
			return this.service.getNumberofReviews();
		}
}
