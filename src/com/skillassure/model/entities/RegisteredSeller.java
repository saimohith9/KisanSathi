package com.skillassure.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Seller")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class RegisteredSeller extends User {

	private String userName;
	private String companyName;
	private String panNo;

	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID")
	private List<Product> products;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

}
