package Com.practice;
import javax.persistence.EntityManagerFactory;

import com.practice.ProductDao;
public class ProductDaoTest {
	EntityManagerFactory emf;
	
	@Test
	public void insertProductTest()
	{
		ProductDao dao=new Productdao();
		Product product=new Product();
		product.srtId(2);
		product.setName("Pencil");  
		product.setPrice(5);
		dao.insertProduct(product);
	}
	public void findById(int id) {
		ProductDao dao=new ProductDao();
		Product p=dao.findById(1); 
		assertNotNull(p);
	}
}
