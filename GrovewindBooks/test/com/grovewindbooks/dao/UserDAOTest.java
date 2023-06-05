package com.grovewindbooks.dao;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grovewindbooks.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		entityManager = entityManagerFactory.createEntityManager();
		
		userDAO = new UserDAO(entityManager);
	}

	//Test createUsers method
	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("z@email.com");
		user1.setFullName("zion smith");
		user1.setPassword("pass123");

		user1 = userDAO.create(user1);
		
		//Test if UserId is greater than 0
		assertTrue(user1.getUserId() > 0);
	}

	@Test
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);
		
		//Test if UserId is greater than 0
		assertTrue(user1.getUserId() > 0);
	}
	
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
