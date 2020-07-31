package com.skillassure.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Project");
		return factory.createEntityManager();
	}
	
	public static void closeEntityManager(EntityManager em) {
		em.close();
	}
}
