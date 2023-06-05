package com.grovewindbooks.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.grovewindbooks.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class UserDAOTest {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static UserDAO userDAO;
	
	//instantiate entityManager, entityManagerFactory, and userDAO
	@BeforeClass
	public static void setUpClass() {
		entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		entityManager = entityManagerFactory.createEntityManager();
		
		//pass entity manager through UserDAO
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
	
	//null user entry test
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldNotSet() {
		Users user1 = new Users();
		
		user1 = userDAO.create(user1);
		
	}
	
	//test updateUsers
	@Test
	public void testUpdateUsers() {
		//instantiation
		Users user = new Users();
		
		//set user information
		user.setUserId(1);
		user.setEmail("eueh@email.net");
		user.setFullName("Henry Jones");
		user.setPassword("testpass");
		
		//pass through method
		user = userDAO.update(user);
		
		//expected value vs database entry
		String expected = "testpass";
		String actual = user.getPassword();
		
		//evaluate the difference
		assertEquals(expected, actual);
		
	}

	@Test
	public void testGetUsersFound() {
		Integer userId = 1;
		Users user = userDAO.get(userId);
		if (user != null) {
			System.out.println(user.getEmail());
		}
		System.out.println(user.getEmail());
		
		assertNotNull(user);
	}
	
	@Test
	public void testGetUsersNotFound() {
		Integer userId = 99;
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId = 5;
		userDAO.delete(userId);
		
		//if the user is not found, then the test was successful
		Users user  = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test(expected = Exception.class)
	public void testDeleteNonExistentUsers() {
		Integer userId = 55;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for (Users user : listUsers) {
			System.out.println(user.getEmail());
		}
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		assertEquals(5, totalUsers);
	}
	
	//close resources created by the setUpClass method
	@AfterClass
	public static void tearDownClass() {
		entityManager.close();
		entityManagerFactory.close();
		
	}
}
