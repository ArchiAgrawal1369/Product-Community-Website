package com.nagaro.ExitTest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagaro.ExitTest.model.Admin;
import com.nagaro.ExitTest.model.User;

@Repository
public interface AdminRepo  extends JpaRepository<Admin,String> {
	
	public Admin findByAdminNameAndAdminPass(String emailId, String password);

}
