package com.nagaro.ExitTest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaro.ExitTest.model.Product;
import com.nagaro.ExitTest.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	//saves product in the repository
	public Product saveProduct(Product prod) {
		return repo.save(prod);
	}
	
	//Fetches product with given Code in the repository for add product function
	public Product fetchProductByProductCode(String prodCode) {
		return repo.findByProductCode(prodCode);
	}
	
	//Get total number of products
	public Long getNumberofProducts()
	{
		return this.repo.count();
	}
	
	
	public List<Product> getProductByName(String productName)
	{
		List<Product> product= this.repo.findByProductName(productName);
		return product;
	}
	public List<Product> getProductByBrand(String productBrand)
	{
		List<Product> product= this.repo.findByProductBrand(productBrand);
		return product;
	}
	public List<Product> getProductByNameAndBrand(String productName,String productBrand)
	{
		List<Product> product= this.repo.findByProductNameAndProductBrand(productName,productBrand);
		return product;
	}
}
