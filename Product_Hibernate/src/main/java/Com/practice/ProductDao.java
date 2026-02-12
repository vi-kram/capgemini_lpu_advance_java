package Com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProductDao {
EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
EntityManager em=emf.createEntityManager();
public void insertProduct(Product p) {
	EntityTrasaction et =em.getTransaction();
	et.begin();
	em.persist(p);
	et.commit();
	
}
public Product findById(int id) {
	Product p=findById(id);
	if(p!=null) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(p);
		et.commit();
	}else {
		System.out.println("Data not exist!!!");
	}
}
}
