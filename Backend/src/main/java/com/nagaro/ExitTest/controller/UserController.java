package com.nagaro.ExitTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nagaro.ExitTest.model.*;
import com.nagaro.ExitTest.repo.*;
import com.nagaro.ExitTest.service.UserService;

@RestController
public class UserController {
	
	@Autowired 
	private UserService service;

	//********************* LOGIN/REGISTER API *************************************
	
	@PostMapping("/register")
	@CrossOrigin(origins="http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		if(tempEmail!=null && !"".equals(tempEmail)) {
			User userObj = service.fetchUserByEmailId(tempEmail);
			if(userObj!=null) {
				throw new Exception("User already exists!");
			}
		}
		User userObj=null;
		userObj = service.saverUser(user);
		return userObj;
	}
	
	@PostMapping(path="/login")
	@CrossOrigin(origins="http://localhost:4200")
	public User loginUser(@RequestBody User user)throws Exception  {
		String tempEmail = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj=null;
		if(tempEmail!=null && tempPass!=null) {
			userObj= service.fetchUserByEmailIdAndPassword(tempEmail, tempPass);
		}
		if(userObj==null) {
			throw new Exception("Wrong credentials!");
		}
		return userObj;
	}

	
	//********************* STATISTICS API ****************************************
	
		//Get the number of Users
		@GetMapping("/count-users")
		@CrossOrigin(origins="http://localhost:4200")
		public Long getProductCount()
		{
			return this.service.getNumberofUsers();
		}
}
