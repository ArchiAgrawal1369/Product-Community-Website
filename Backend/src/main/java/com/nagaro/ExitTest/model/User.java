package com.nagaro.ExitTest.model;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="loginUser")
public class User {
	@Id
	@Column(name="emailId")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	
	
	public User() {
	}
	
	public User(int id, String emailId, String password, String firstName, String lastName) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
