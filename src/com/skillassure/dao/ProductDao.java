package com.skillassure.dao;

import java.util.List;

import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredSeller;

public interface ProductDao {

	long saveProduct(Product product);

	long updateProduct(Product product);

	long deleteProduct(Product product);

	Product findProduct(long id);
	
	List<Product> findProduct(String name);

	List<Product> findAllProducts();
	
	List<Product> findSellerProducts(long id);
	
}
