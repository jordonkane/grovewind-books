package com.grovewindbooks.entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CategoryTest {

	public static void main(String[] args) {
		Category newCat = new Category("Advanced Java");

		//Instantiating EntityManager and EntityManagerFactory
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GrovewindBooks");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Begin Transaction
		entityManager.getTransaction().begin();
		entityManager.persist(newCat);
		
		//Commit and close Transaction
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("A category object was persisted.");
	}

}
