package com.grovewindbooks.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.grovewindbooks.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class UserDAOTest {

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("wh8273e@email.com");
		user1.setFullName("William Henry");
		user1.setPassword("Tpass834");

		//Instantiating EntityManager and EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Begin Transaction
		entityManager.getTransaction().begin();
		entityManager.persist(user1);
		
		//Commit and close Transaction
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}

}
