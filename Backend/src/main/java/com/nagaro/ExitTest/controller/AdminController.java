package com.nagaro.ExitTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagaro.ExitTest.model.Admin;
import com.nagaro.ExitTest.model.Product;
import com.nagaro.ExitTest.model.ProductReviews;
import com.nagaro.ExitTest.repo.ProductRepo;
import com.nagaro.ExitTest.service.AdminService;
import com.nagaro.ExitTest.service.ProductService;
import com.nagaro.ExitTest.service.ReviewService;

@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService service;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ProductRepo repo;
	
	
	//Admin login
	@PostMapping(path="/admin")
	@CrossOrigin(origins="http://localhost:4200")
	public Admin loginAdmin(@RequestBody Admin admin)throws Exception  {
		String tempEmail = admin.getAdminName();
		String tempPass = admin.getAdminPass();
		Admin details=null;
		if(tempEmail!=null && tempPass!=null) {
			details= adminService.fetchAdminByAdminNameAndAdminPass(tempEmail, tempPass);
		}
		if(details==null) {
			throw new Exception("Wrong credentials!");
		}
		return details;
	}
	
		//*********************REVIEWS API ****************************************
	
		//View all reviews that are pending (administrator)
		@GetMapping("/review")
		@CrossOrigin(origins="http://localhost:4200")
		public List<ProductReviews> getReviews() {
			List<ProductReviews> list = this.reviewService.getReview();
			return list;
		}

		//Approve/Reject reviews (administrator)
		@PutMapping("/review/{id}")
		@CrossOrigin(origins="http://localhost:4200")
		public ResponseEntity approveOrRejectReview(@RequestBody String state, @PathVariable("id") int id) 
		{	
			reviewService.modifyReviewState(state,id);
			
		return ResponseEntity.status(200).build();
		}
		
		
		
		//********************* PRODUCT API ****************************************
		
		//Add new products only (administrator)
		@PostMapping("/product")
		@CrossOrigin(origins="http://localhost:4200")
		public Product addProduct(@RequestBody Product product) throws Exception {
			String tempCode = product.getProductCode();
			if(tempCode!=null && !"".equals(tempCode)) {
				Product prodObj = service.fetchProductByProductCode(tempCode);
				if(prodObj!=null) {
					throw new Exception("Product already exists!");
				}
			}
			Product prodObj=null;
			prodObj = service.saveProduct(product);
			return prodObj;
		}
		
		//Edit existing products only (administrator)
		@PutMapping("/product")
		@CrossOrigin(origins="http://localhost:4200")
		public Product saveOrUpdateProduct(@RequestBody Product product) 
		{	Product prodObj=null;
			prodObj = service.saveProduct(product);
			return prodObj;
			
		}
		
		//Delete products (administrator)
		@DeleteMapping("/product/{productCode}")
		@CrossOrigin(origins="http://localhost:4200")
		public boolean delete(@PathVariable("productCode") String productCode)
		{	Product a = repo.getById(productCode);
			repo.delete(a);
			return true;
		}
		
		
}
