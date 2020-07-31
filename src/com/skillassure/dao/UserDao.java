package com.skillassure.dao;

import java.util.List;

import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Login;
import com.skillassure.model.entities.User;

public interface UserDao {

	User saveUser(User user);
	
	User findUser(long id);
	
	User findUser(String email);
	
	List<User> findUsers(String name);
	
	String validateUser(Login login);

	List<User> findAllUsers();
	
}
