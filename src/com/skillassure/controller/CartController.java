package com.skillassure.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillassure.exceptions.ProductNotFoundException;
import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Cart;
import com.skillassure.model.entities.CartItem;
import com.skillassure.model.entities.Order;
import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredCustomer;
import com.skillassure.model.entities.User;
import com.skillassure.service.ProductService;
import com.skillassure.service.UserService;
import com.skillassure.service.impl.ProductServiceImpl;
import com.skillassure.service.impl.UserServiceImpl;

@WebServlet({"/cart","/cart/checkCustomer","/cart/updateItem","/cart/removeItem","/cart/order"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private ProductService prodService;

	public CartController() {
		userService = new UserServiceImpl();
		prodService = new ProductServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String responsePage = null;
		if (url.endsWith("/checkCustomer")) {
			responsePage = checkCustomer(request, response);
		} else if (url.endsWith("/updateItem")) {
			responsePage = updateCartItem(request, response);
		} else if (url.endsWith("/removeItem")) {
			responsePage = removeCartItem(request, response);
		} else if (url.endsWith("/order")) {
			try {
				responsePage = processOrder(request,response);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}
		getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}

	private String processOrder(HttpServletRequest request, HttpServletResponse response) throws UserNotFoundException {
			HttpSession session = request.getSession();
			String customerMail = (String) session.getAttribute("username");
			Cart cart = (Cart) session.getAttribute("cart");
			User customer = userService.getUser(customerMail);
			Order order = new Order();
			order.setCustomer(customer);
			order.setItems(cart.getCartItems());
			order.setOrderDate(new Date());
			session.setAttribute("order", order);
			session.removeAttribute("cart");
			return "/product/order.jsp";
	}

	private String removeCartItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			long productid = Long.parseLong(request.getParameter("productid"));
			Product product = prodService.getProduct(productid);

			if (cart != null && product != null) {
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cart.removeItem(cartItem);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		return "/product/cart.jsp";
	}

	private String updateCartItem(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
			long productId = Long.parseLong(request.getParameter("productid"));
			Product product = prodService.getProduct(productId);
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			if (cart != null && product != null) {
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setQty(quantity);
				if (quantity > 0) {
					cart.addItem(cartItem);
				} else {
					cart.removeItem(cartItem);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		return "/product/cart.jsp";
	}

	private String checkCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		String page = null;
		User customer = null;
		try {
			customer = userService.getUser(email);
			if (customer == null) {
				page = "/home/customerregister.jsp";
			} else {
				page = "/product/payment.jsp";
			}
		} catch (UserNotFoundException e) {
			response.sendRedirect(page);
			e.printStackTrace();
		}
		request.setAttribute("username", email);
		return page;
	}


}
