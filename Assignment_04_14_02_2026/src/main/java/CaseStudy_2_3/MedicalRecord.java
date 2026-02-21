package CaseStudy_2_3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MedicalRecord {
@Id
private int Id;
private String bloodGroup;
private String allergies;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getBloodGroup() {
	return bloodGroup;
}
public void setBloodGroup(String bloodGroup) {
	this.bloodGroup = bloodGroup;
}
public String getAllergies() {
	return allergies;
}
public void setAllergies(String allergies) {
	this.allergies = allergies;
}


}
