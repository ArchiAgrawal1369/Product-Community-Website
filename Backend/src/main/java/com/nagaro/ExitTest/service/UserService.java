package com.nagaro.ExitTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaro.ExitTest.model.User;
import com.nagaro.ExitTest.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	//Service to register new user by saving details
	public User saverUser(User user) {
		return repo.save(user);
	}
	
	
	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String email, String pass) {
		return repo.findByEmailIdAndPassword(email, pass);
	}
	
	public Long getNumberofUsers(){
		return this.repo.count();
	}
}
