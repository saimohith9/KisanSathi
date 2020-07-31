package com.skillassure.service.impl;

import java.util.List;

import com.skillassure.dao.ProductDao;
import com.skillassure.dao.jpa.JpaProductDao;
import com.skillassure.exceptions.ProductNotFoundException;
import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredSeller;
import com.skillassure.service.ProductService;

public class ProductServiceImpl implements ProductService {

	public ProductDao dao;

	public ProductServiceImpl() {
		dao = new JpaProductDao();
	}

	@Override
	public long addProduct(Product product) throws ProductNotFoundException {
		List<Product> productFromDao = dao.findProduct(product.getProductName());
		if (productFromDao.size() == 0) {
			dao.saveProduct(product);
			return product.getId();
		} else {
			throw new ProductNotFoundException("Product already exists with " + product.getId());
		}
	}

	@Override
	public long editProduct(Product product) throws ProductNotFoundException {
		Product productFromDao = dao.findProduct(product.getId());
		if (productFromDao == null) {
			throw new ProductNotFoundException("Product Doesn't exists");
		}
		return dao.updateProduct(product);
	}

	@Override
	public long deleteProduct(Product product) throws ProductNotFoundException {
		Product productFromDao = dao.findProduct(product.getId());
		if (productFromDao == null) {
			throw new ProductNotFoundException("Product Doesn't exists");
		}
		return dao.deleteProduct(product);
	}

	@Override
	public Product getProduct(long id) throws ProductNotFoundException {
		if (dao.findProduct(id) == null) {
			throw new ProductNotFoundException("No such product doesn't exist");
		}
		return dao.findProduct(id);
	}

	@Override
	public List<Product> getProduct(String name) throws ProductNotFoundException {
		if (dao.findProduct(name).size() == 0) {
			throw new ProductNotFoundException("No such product exists");
		}
		return dao.findProduct(name);
	}

	@Override
	public List<Product> getAllProducts() throws ProductNotFoundException {
		if (dao.findAllProducts().size() == 0) {
			throw new ProductNotFoundException("Products doesn't exist");
		}
		return dao.findAllProducts();
	}

	@Override
	public List<Product> getSellerProducts(long id) throws ProductNotFoundException {
		if (dao.findSellerProducts(id).size() == 0) {
			throw new ProductNotFoundException("Product doesn't exists for this seller");
		}
		return dao.findSellerProducts(id);
	}


}
