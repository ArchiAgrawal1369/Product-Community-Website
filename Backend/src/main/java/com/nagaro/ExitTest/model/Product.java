package com.nagaro.ExitTest.model;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="productCode")
	private String productCode;
	@Column(name="productName")
	private String productName;
	@Column(name="productBrand")
	private String productBrand;
	@Column(name="productColor")
	private String productColor;
	@Column(name="productPrice")
	private Double productPrice;
	
	@OneToMany(mappedBy = "product")
	private List<ProductReviews> review;
	
	
	public Product() {}
	public Product(String productCode, String productName, String productBrand, String productColor,
			Double productPrice, List<ProductReviews> review) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productBrand = productBrand;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.review = review;
	}
	
	public List<ProductReviews> getReview() {
		return review;
	}
	public void setReview(List<ProductReviews> review) {
		this.review = review;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
}
