package com.grovewindbooks.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.grovewindbooks.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAOTest {

	//Test createUsers method
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("test@email.com");
		user1.setFullName("Test Name");
		user1.setPassword("testpassword");

		//Instantiating EntityManager and EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDAO = new UserDAO(entityManager);
		user1 = userDAO.create(user1);
		
		entityManager.close();
		entityManagerFactory.close();
		
		//Test if UserId is greater than 0
		assertTrue(user1.getUserId() > 0);
	}

	@Test
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
		user1.setEmail("test@email.com");
		user1.setFullName("Test Name");
		user1.setPassword("testpassword");

		//Instantiating EntityManager and EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		UserDAO userDAO = new UserDAO(entityManager);
		user1 = userDAO.create(user1);
		
		entityManager.close();
		entityManagerFactory.close();
		
		//Test if UserId is greater than 0
		assertTrue(user1.getUserId() > 0);
	}
}
