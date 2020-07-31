package com.skillassure.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.entities.RegisteredSeller;
import com.skillassure.model.entities.Role;
import com.skillassure.service.UserService;
import com.skillassure.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/seller/register")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	private String host;
	private String port;
	private String user;
	private String pass;

	public SellerController() {
		super();
		service = new UserServiceImpl();
	}

	@Override
	public void init() {
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI();
		String responsePage = "/home/sellerregister.jsp";
		if (url.endsWith("/seller/register"))
			try {
				responsePage = registerSeller(request, response);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		getServletContext().getRequestDispatcher(responsePage).forward(request, response);
	}

	private String registerSeller(HttpServletRequest request, HttpServletResponse response)
			throws IOException, UserNotFoundException{
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long phoneNo = Long.parseLong(request.getParameter("phoneNo"));
		String password = request.getParameter("password");
		String cPassword = request.getParameter("Cpassword");
		String companyName = request.getParameter("companyName");
		String panNo = request.getParameter("panNo");

		RegisteredSeller seller = new RegisteredSeller();
		seller.setConfirmPassword(cPassword);
		seller.setEmailId(email);
		seller.setName(name);
		seller.setPassword(password);
		seller.setCompanyName(companyName);
		seller.setPanNo(panNo);
		seller.setPhoneNo(phoneNo);
		seller.setUserName(email);
		seller.setRole(Role.SELLER);
				if(service.addUser(seller) == null) {
				request.setAttribute("Notification", "Seller Email Id already Registered");
				} else {
					request.setAttribute("Notification", "Seller Registered Successfully");
				}
		String recepient = email;
		String content = "Hi " + name + ",/n/t Thanks for registering";
		String subject = "Reg - Kisansathi Registration";
		//EmailUtil.sendEmail(host, port, user, pass, recepient, subject, content);
		return "/home/homepage.jsp";
	}

}
