package com.maping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User {
	public static void main(String[] args) {

	    EntityManagerFactory emf =
	            Persistence.createEntityManagerFactory("postgres");

	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();


	    Engine e = new Engine();
	    e.setId(100);
	    e.setType("V8");
	    e.setFuelType("Petrol");
	    e.setMileage("12");
	    e.setCc("3000");


	    Car c = new Car();
	    c.setId(1);
	    c.setBrand("Volkswagen");
	    c.setModel("Polo GT10");
	    c.setModelYear("2019");
	    c.setPrice(1000000);
	    c.setEngine(e);


	    et.begin();
	    em.persist(e);
	    em.persist(c);
	    et.commit();
	}

}
