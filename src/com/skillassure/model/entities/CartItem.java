package com.skillassure.model.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@OneToOne
	private Product product;
	
	private int qty =1;

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getTotalPrice() {
		return product.getPrice() * qty;
	}
	
	
}
