package com.nagaro.ExitTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaro.ExitTest.model.Admin;
import com.nagaro.ExitTest.model.User;
import com.nagaro.ExitTest.repo.AdminRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo repo;
	
	public Admin fetchAdminByAdminNameAndAdminPass(String email, String pass) {
		return repo.findByAdminNameAndAdminPass(email, pass);
	}

}
