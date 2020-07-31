package com.skillassure.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.skillassure.dao.UserDao;
import com.skillassure.exceptions.UserNotFoundException;
import com.skillassure.model.dto.Login;
import com.skillassure.model.entities.Role;
import com.skillassure.model.entities.User;
import com.skillassure.util.JPAUtil;

public class JpaUserDao implements UserDao {

	@Override
	public User saveUser(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
		JPAUtil.closeEntityManager(em);
		return user;
	}

	@Override
	public String validateUser(Login login){
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select u from User u where u.emailId =?1 and u.password =?2", User.class);
		query.setParameter(1, login.getUserName());
		query.setParameter(2, login.getPassword());
		// Object userDb = query.getParameterValue("emailId");
		// Object passwordDb = query.getParameterValue("password");
		// Object role = query.getParameterValue("role");
		@SuppressWarnings("unchecked")
		List<User> loginDao = query.getResultList();
		Role role = null;
		for (User user : loginDao) {
			role = user.getRole();
		}
		if (role.toString() == "CUSTOMER") {
			JPAUtil.closeEntityManager(em);
			return Role.CUSTOMER.toString();
		} else if(role.toString() == "SELLER"){
			JPAUtil.closeEntityManager(em);
			return Role.SELLER.toString();
		} else {
			return null;
		}
	}

	@Override
	public List<User> findAllUsers() {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select u from User u");
		List<User> users = query.getResultList();
		JPAUtil.closeEntityManager(em);
		return users;
	}

	@Override
	public User findUser(long id) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select u from User u where u.USER_ID =?1", User.class);
		query.setParameter(1, id);
		List<User> users = query.getResultList();
		User user = (users.size() == 0) ? null : users.get(0);
		JPAUtil.closeEntityManager(em);
		return user;
	}

	@Override
	public List<User> findUsers(String name) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select u from User u where u.name =?1", User.class);
		query.setParameter(1, name);
		List<User> users = query.getResultList();
		JPAUtil.closeEntityManager(em);
		return users;
	}

	@Override
	public User findUser(String email) {
		EntityManager em = JPAUtil.getEntityManager();
		Query query = em.createQuery("select u from User u where u.emailId =:email", User.class);
		query.setParameter("email", email);
		List<User> users = query.getResultList();
		User user = (users.size() == 0) ? null : users.get(0);
		JPAUtil.closeEntityManager(em);
		return user;
	}

}
