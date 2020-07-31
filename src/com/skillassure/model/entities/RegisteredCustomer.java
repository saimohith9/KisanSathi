package com.skillassure.model.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class RegisteredCustomer extends User {
	
	
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
