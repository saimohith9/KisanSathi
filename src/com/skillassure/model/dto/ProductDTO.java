package com.skillassure.model.dto;


import com.skillassure.model.entities.Product;

public class ProductDTO {

	private String productName;
	private String productDescription;
	private float price;
	private Byte[] image;

	public Product convertToEntity() {
		Product product = new Product();
		product.setImage(image);
		product.setPrice(price);
		product.setProductDescription(productDescription);
		product.setProductName(productName);
		return product;
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

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}


	

}
