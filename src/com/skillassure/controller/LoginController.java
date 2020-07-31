package com.skillassure.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Login;
import com.skillassure.model.entities.Role;
import com.skillassure.service.UserService;
import com.skillassure.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();

	}

	@Override
	public void init() {
		service = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String page = null;
		try {
			page = authenticate(request, response);
		} catch (ServletException | IOException | UserNotFoundException e) {
			e.printStackTrace();
		}
		getServletContext().getRequestDispatcher(page).forward(request, response);
	}

	private String authenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UserNotFoundException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Login login = new Login();
		login.setUserName(userName);
		login.setPassword(password);
		HttpSession session = request.getSession();
		String page = null;
		try {
			if (service.validateUser(login) == Role.CUSTOMER.toString()) {
				session.setAttribute("username", userName);
				page = "/product/products-list";
			} else if (service.validateUser(login) == Role.SELLER.toString()) {
				session.setAttribute("username", userName);
				page = "/product/sellerproducts";
			} else {
				session.setAttribute("username", userName);
				request.setAttribute("Notification", "Bad Credentials");
				page = "/home/login.jsp";
			}
		} catch (NullPointerException e) {
			session.setAttribute("username", userName);
			request.setAttribute("Notification", "Invalid Username or Password");
			page = "/home/login.jsp";
			e.printStackTrace();
		}
		return page;
	}
}
