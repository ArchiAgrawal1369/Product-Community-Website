package com.nagaro.ExitTest.repo;

import com.nagaro.ExitTest.model.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepo extends JpaRepository<ProductReviews,Integer>{

	List<ProductReviews> findByState(String state);
	public ProductReviews findByReviewCode(int reviewCode);
	public List<ProductReviews> findByProductProductCodeAndState(String prouctCode, String state);

}
