package com.skillassure.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.skillassure.model.entities.CartItem;

public class Cart {

	private List<CartItem> cartItems;

	public Cart() {
		cartItems = new ArrayList<>();
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public int getItemsSize() {
		return cartItems.size();
	}

	public double getTotalPrice() {
		double total = 0.0;
		for (CartItem c : cartItems) {
			total += c.getTotalPrice();
		}
		return total;
	}

	public void addItem(CartItem cartItem) {
		long id = cartItem.getProduct().getId();
		int qty = cartItem.getQty();

		for (CartItem c : cartItems) {
			if (c.getProduct().getId() == id) {
				c.setQty(qty);
			}
		}
		cartItems.add(cartItem);
	}

	public void removeItem(CartItem cartItem) {
		long id = cartItem.getProduct().getId();
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getProduct().getId() == id) {
				cartItems.remove(i);
			}
		}
	}
}
