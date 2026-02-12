package Com.practice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
public class Product {
	
	
	
		@Id
		private int id;
		private String name;
		private double Quantity;
		private double price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getQuantity() {
			return Quantity;
		}
		public void setQuantity(double quantity) {
			Quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		
		
}
