package maping;
import java.util.Arrays;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Main {
	
	    public static void main(String[] args) {

	        EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("collegePU");

	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();

	        Student s1 = new Student();
	        s1.setName("A");
	        s1.setBranch("B1");

	        Student s2 = new Student();
	        s2.setName("B");
	        s2.setBranch("B2");

	        College college = new College();
	        college.setName("ABC College");
	        college.setLocation("Delhi");
	        college.setPincode("110001");
	        college.setStudents(Arrays.asList(s1, s2));

	        em.persist(college);

	        em.getTransaction().commit();

	        em.close();
	        emf.close();
	    }
	}


