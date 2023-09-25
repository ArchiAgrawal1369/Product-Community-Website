package com.nagaro.ExitTest.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="reviews")
public class ProductReviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewCode;
	@Column(name="review")
	private String review;
	@Column(name="ratings")
	private String ratings;
	@Column(name="state")
	private String state;
	
	@ManyToOne
	@JsonIgnoreProperties("review")
	private Product product;
	
	public ProductReviews() {}

	public ProductReviews(int reviewCode, String review, String ratings, String state, Product product) {
		super();
		this.reviewCode = reviewCode;
		this.review = review;
		this.ratings = ratings;
		this.state= state;
		this.product = product;
	}

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
