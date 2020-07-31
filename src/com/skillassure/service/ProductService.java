package com.skillassure.service;

import java.util.List;

import com.skillassure.exceptions.ProductNotFoundException;
import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredSeller;

public interface ProductService {

	long addProduct(Product product) throws ProductNotFoundException;

	long editProduct(Product product) throws ProductNotFoundException;

	long deleteProduct(Product product) throws ProductNotFoundException;

	Product getProduct(long id) throws ProductNotFoundException;

	List<Product> getProduct(String name) throws ProductNotFoundException;

	List<Product> getAllProducts() throws ProductNotFoundException;
	
	List<Product> getSellerProducts(long id) throws ProductNotFoundException;
	
}
