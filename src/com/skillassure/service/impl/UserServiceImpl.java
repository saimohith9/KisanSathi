package com.skillassure.service.impl;

import java.util.List;

import com.skillassure.dao.UserDao;
import com.skillassure.dao.jpa.JpaUserDao;
import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Login;
import com.skillassure.model.entities.User;
import com.skillassure.service.UserService;

public class UserServiceImpl implements UserService {

	public UserDao dao;

	public UserServiceImpl() {
		dao = new JpaUserDao();
	}

	@Override
	public User addUser(User user) throws UserNotFoundException {
		User userFromDao = dao.findUser(user.getEmailId());
		if (userFromDao != null) {
			throw new UserNotFoundException("User already exists");
		}
		return dao.saveUser(user);
	}

	@Override
	public String validateUser(Login login) throws UserNotFoundException {
		if (dao.validateUser(login) == null) {
			throw new UserNotFoundException("Bad Credentials");
	}
		return dao.validateUser(login);
	}

	@Override
	public List<User> getAllUsers() throws UserNotFoundException {
		List<User> users = dao.findAllUsers();
		if (users != null)
			throw new UserNotFoundException("Users doesn't exist");
		return users;
	}

	@Override
	public User getUser(long id) throws UserNotFoundException {
		if (dao.findUser(id) == null)
			throw new UserNotFoundException("No such user exists");
		return dao.findUser(id);
	}

	@Override
	public List<User> getUsers(String name) throws UserNotFoundException {
		if (dao.findUsers(name) == null)
			throw new UserNotFoundException("user doesn't exists");
		return dao.findUsers(name);
	}

	@Override
	public User getUser(String email) throws UserNotFoundException {
//		if (dao.findUser(email) == null) {
//			throw new UserNotFoundException("User with this email doesn't exists");
//		}
		return dao.findUser(email);
	}

}
