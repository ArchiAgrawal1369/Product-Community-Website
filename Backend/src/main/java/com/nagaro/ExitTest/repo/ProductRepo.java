package com.nagaro.ExitTest.repo;
import com.nagaro.ExitTest.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,String>{
	public Product findByProductCode(String productCode);
	public List<Product> findByProductName(String productName);
	public List<Product> findByProductBrand(String productBrand);
	public List<Product> findByProductNameAndProductBrand(String productName,String productBrand);
	
	public List<Product> findByProductCodeOrProductNameContainingOrProductBrandContaining(String productCode, String productName, String productBrand);
}
