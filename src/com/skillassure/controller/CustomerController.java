package com.skillassure.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.entities.RegisteredCustomer;
import com.skillassure.model.entities.Role;
import com.skillassure.service.UserService;
import com.skillassure.service.impl.UserServiceImpl;

@WebServlet(name = "CustomerController", urlPatterns = "/customer/register")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService service = new UserServiceImpl();
	private String host;
	private String port;
	private String user;
	private String pass;

	public CustomerController() {
		super();
		service = new UserServiceImpl();
	}

	/*
	 * @Override public void init() { ServletContext context = getServletContext();
	 * host = context.getInitParameter("host"); port =
	 * context.getInitParameter("port"); user = context.getInitParameter("user");
	 * pass = context.getInitParameter("pass"); }
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURI();
		String responsePage = null;
		if (url.endsWith("/customer/register"))
			try {
				responsePage = registerCustomer(request, response);
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}

		getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}

	public String registerCustomer(HttpServletRequest request, HttpServletResponse response)
			throws UserNotFoundException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
		String password = request.getParameter("password");
		String cPassword = request.getParameter("Cpassword");

		RegisteredCustomer customer = new RegisteredCustomer();
		customer.setConfirmPassword(cPassword);
		customer.setName(name);
		customer.setUserName(email);
		customer.setEmailId(email);
		customer.setPassword(password);
		customer.setPhoneNo(phoneNo);
		customer.setRole(Role.CUSTOMER);

		if (service.addUser(customer) == null) {
			request.setAttribute("Notification", "Customer Email Already Registered");
		} else {
			request.setAttribute("Notification", "Customer Registered Successfully");
		}
		String recepient = email;
		String content = "Hi " + name + ",/n/t Thanks for registering";
		String subject = "Reg - Kisansathi Registration";
		// EmailUtil.sendEmail(host, port, user, pass, recepient, subject, content);
		return "/home/homepage.jsp";
	}
}
