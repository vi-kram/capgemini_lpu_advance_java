package Com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductDetailsTest {
	static EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeAll
	public static void initEmf() {
		System.out.println("Init emf");
		emf = Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public void initEm() {
		em=emf.createEntityManager(); 
	}

	@Test
	public void insertProductTest() {
		ProductDetails details = new ProductDetails();
		Product product = new Product();
		product.setId(3);
		product.setName("pen");
		product.setPrice(10);
		product.setQuantity(5);

		details.insertProduct(product);
	}
	
	@Test
	public void findProductTest() {
		ProductDetails details = new ProductDetails();
		Product product = details.findProduct(2);
		assertNotNull(product);
	}
	
	@AfterEach
	public void destroyEm() {
		em.close();
	}
	
	@AfterAll
	public static void destroyEmf() {
		emf.close();
	}
}