package com.nagaro.ExitTest.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaro.ExitTest.model.Product;
import com.nagaro.ExitTest.model.ProductReviews;
import com.nagaro.ExitTest.repo.ReviewsRepo;

@Service
public class ReviewService {

	@Autowired
	private ReviewsRepo repo;
	
	//Get total number of reviews
	public Long getNumberofReviews()
	{
		return this.repo.count();
	}
	
	@Autowired
	private ProductService productService;
	
	public ProductReviews addReviews(ProductReviews review, String id) {
		Product p = productService.fetchProductByProductCode(id);
		p.getReview().add(review);
		productService.saveProduct(p);

		review.setProduct(p);
		repo.save(review);

		return review;
	}
	
	public List<ProductReviews> getReview() {
		String val= "pending";
		List<ProductReviews> list = (List<ProductReviews>) this.repo.findByState(val);
		return list;

	}
	
	public List<ProductReviews> getApprovedReview(String id){
		String val= "approved";
		List<ProductReviews> list = (List<ProductReviews>) this.repo.findByProductProductCodeAndState(id,val);
		
		return list;
	}

	public void modifyReviewState(String state, int id) {
		ProductReviews review = this.repo.findByReviewCode(id);
		review.setState(state);
		this.repo.save(review);
		}

}














