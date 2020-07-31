package com.skillassure.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import com.skillassure.dao.ProductDao;
import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredSeller;
import com.skillassure.model.entities.User;
import com.skillassure.util.JPAUtil;

public class JpaProductDao implements ProductDao {

	@Override
	public long saveProduct(Product product) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(product);
		et.commit();
		JPAUtil.closeEntityManager(em);
		return product.getId();
	}

	@Override
	public long updateProduct(Product product) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		Product existingProduct = em.find(Product.class, product.getId());
		existingProduct.setImage(product.getImage());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setProductDescription(product.getProductDescription());
		existingProduct.setProductName(product.getProductName());
		em.persist(existingProduct);
		et.commit();
		JPAUtil.closeEntityManager(em);
		return existingProduct.getId();
	}

	@Override
	public long deleteProduct(Product product) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(product.getSeller());
		product = em.find(Product.class, product.getId());
		em.remove(product);
		et.commit();
		JPAUtil.closeEntityManager(em);
		return product.getId();
	}

	@Override
	public Product findProduct(long id) {
		Product product = null;
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Product> query = em.createQuery("select p from Product p where p.id = ?1", Product.class);
		query.setParameter(1, id);
		List<Product> products = query.getResultList();
		product = (products.size() == 0) ? null : products.get(0);
		JPAUtil.closeEntityManager(em);
		return product;
	}

	@Override
	public List<Product> findProduct(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select p from Product p where p.productName = :name", Product.class);
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		List<Product> products = query.getResultList();
		JPAUtil.closeEntityManager(em);
		return products;
	}

	@Override
	public List<Product> findAllProducts() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select p from Product p", Product.class);
		@SuppressWarnings("unchecked")
		List<Product> products = query.getResultList();
		JPAUtil.closeEntityManager(em);
		return products;
	}

	@Override
	public List<Product> findSellerProducts(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query =  em.createQuery(
				"select p from Product p join p.seller s on s.id = p.seller.id where s.id = ?1");
		query.setParameter(1,id);
		@SuppressWarnings("unchecked")
		List<Product> products = query.getResultList();
		JPAUtil.closeEntityManager(em);
		return products;
	}

}
