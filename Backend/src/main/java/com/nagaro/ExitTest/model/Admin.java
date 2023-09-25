package com.nagaro.ExitTest.model;
import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	private String adminName;
	private String adminPass;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	

}
