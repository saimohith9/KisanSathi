package com.skillassure.model.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.skillassure.model.dto.ProductDTO;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUCT_ID")
	private long id;
	private String productName;
	private String productDescription;
	private float price;
	private Byte[] image;

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID")
	private RegisteredSeller seller;

	public RegisteredSeller getSeller() {
		return seller;
	}

	public void setSeller(RegisteredSeller seller) {
		this.seller = seller;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public ProductDTO convertTODTO() {
		ProductDTO dto = new ProductDTO();
		dto.setImage(getImage());
		dto.setPrice(getPrice());
		dto.setProductDescription(getProductDescription());
		dto.setProductName(getProductName());
		return dto;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

}
