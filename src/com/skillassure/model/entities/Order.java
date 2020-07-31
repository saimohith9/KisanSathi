package com.skillassure.model.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private long id;
	
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private List<CartItem> items;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "USER_ID")
	private User customer;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDate;
	
	private boolean isProcessed;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	 public double getOrderTotal() {
	      double total = 0.0;
	      for (CartItem i : items) {
	         total += i.getTotalPrice();
	      }
	      return total;
	   }

	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	 
	public double getTotalPrice() {
		double total = 0.0;
		for (CartItem c : items) {
			total += c.getTotalPrice();
		}
		return total;
	}

}
