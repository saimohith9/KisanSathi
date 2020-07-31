package com.skillassure.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillassure.exceptions.ProductNotFoundException;
import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Cart;
import com.skillassure.model.dto.ProductDTO;
import com.skillassure.model.entities.CartItem;
import com.skillassure.model.entities.Product;
import com.skillassure.model.entities.RegisteredSeller;
import com.skillassure.model.entities.User;
import com.skillassure.service.ProductService;
import com.skillassure.service.UserService;
import com.skillassure.service.impl.ProductServiceImpl;
import com.skillassure.service.impl.UserServiceImpl;

@WebServlet({ "/product/products-list", "/product/sellerproducts", "/product/addProduct", "/product/delete",
		"/product/addtocart" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService prodService;
	private UserService userService;

	public ProductController() {
		prodService = new ProductServiceImpl();
		userService = new UserServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		String responsePage = null;
		if (url.endsWith("/sellerproducts")) {
			responsePage = displaySellerProducts(request, response);
		} else if (url.endsWith("/delete")) {
			responsePage = deleteProduct(request, response);
		} else if (url.endsWith("/addtocart")) {
			responsePage = addToCart(request, response);
		} else if (url.endsWith("/products-list")) {
			responsePage = displayProducts(request, response);
		} else if (url.endsWith("/addProduct")) {
			try {
				responsePage = addProduct(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			} catch (ProductNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				responsePage = "/product/check.jsp";
			}
		}
		request.getRequestDispatcher(responsePage).forward(request, response);
	}

	private String displayProducts(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = new ArrayList<Product>();
		try {
			products = prodService.getAllProducts();
			request.setAttribute("allproducts", products);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		return "/product/products-list.jsp";
	}

	private String addToCart(HttpServletRequest request, HttpServletResponse response) {
		long productId = Long.parseLong(request.getParameter("id"));
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		CartItem cartItem = new CartItem();
		if (cart == null) {
			cart = new Cart();
		}
		try {
			Product product = prodService.getProduct(productId);
			if (product != null) {
				cartItem.setProduct(product);
				cart.addItem(cartItem);
			}else if(cart.getCartItems().contains(cartItem)) {
				cart.removeItem(cartItem);
			}
				session.setAttribute("cart", cart);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		session.setAttribute("cartItemCount", cart.getCartItems().size());

		session.setAttribute("totalprice", cart.getTotalPrice());
		return "/product/cart.jsp";
	}

	private String displaySellerProducts(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		String page = null;
		try {
			String sellerMail = (String) session.getAttribute("username");
			RegisteredSeller seller = (RegisteredSeller) userService.getUser(sellerMail);
			System.out.println(sellerMail);
			List<Product> products;
			products = prodService.getSellerProducts(seller.getId());
			session.setAttribute("products", products);
			page = "/product/sellerproducts.jsp";
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		} catch(Exception e) {
			page = "/home/error.jsp";
			e.printStackTrace();
		}
		return page;
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		try {
			Product getProduct = prodService.getProduct(id);
			prodService.deleteProduct(getProduct);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		return "/product/deleteproduct.jsp";
	}

	private String addProduct(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException, UserNotFoundException, ProductNotFoundException {
		String productName = request.getParameter("proname");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		// byte[] image =yte.valueOf(request.getParameter("image"));
		// InputStream istream = null;
		ProductDTO product = new ProductDTO();
		// product.setImage((Part)image);
		product.setPrice(price);
		product.setProductName(productName);
		product.setProductDescription(description);
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		User seller = userService.getUser(email);
		Product entity = product.convertToEntity();
		entity.setSeller((RegisteredSeller) seller);
		prodService.addProduct(entity);
		request.setAttribute("success", "Product Added Successfully");
		return "/product/addProduct.jsp";
	}
}
