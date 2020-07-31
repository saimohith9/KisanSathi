package com.skillassure.service;

import java.util.List;

import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Login;
import com.skillassure.model.entities.User;

public interface UserService {
	User addUser(User user) throws UserNotFoundException;

	String validateUser(Login login) throws UserNotFoundException;

	List<User> getAllUsers() throws UserNotFoundException;

	User getUser(long id) throws UserNotFoundException;
	
	User getUser(String email) throws UserNotFoundException;

	List<User> getUsers(String name) throws UserNotFoundException;
	
}
