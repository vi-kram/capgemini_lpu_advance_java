package CaseStudy_2_3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DoctorDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    // this is used to insert the detail of doctor into the table
    public void saveDoctor() {

        EntityTransaction et = em.getTransaction();

        Doctor doctor = new Doctor();
        doctor.setId(201);
        doctor.setName("Dr Sharma");
        doctor.setSpecialization("Cardiologist");

        et.begin();
        em.persist(doctor);
        et.commit();
    }

    // this method is used to find the doctor with its id
    public Doctor findById(int id) {
        return em.find(Doctor.class, id);
    }

    // this method is used to update existing doctor detail
    public void updateDoctor(int id, String newName, String newSpecialization) {

        EntityTransaction et = em.getTransaction();

        Doctor doctor = em.find(Doctor.class, id);

        if (doctor != null) {
            et.begin();
            doctor.setName(newName);
            doctor.setSpecialization(newSpecialization);
            et.commit();
        }

        em.close();
    }

    // this method is used to delete doctor by its id
    public void deleteDoctor1(Doctor doctor2) {

        EntityTransaction et = em.getTransaction();

        Doctor doctor = em.find(Doctor.class, doctor2);

        if (doctor != null) {
            et.begin();
            em.remove(doctor);
            et.commit();
        }

        em.close();
    }

	public Doctor findById(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	public Doctor findById(int doctorId) {
		// TODO Auto-generated method stub
		return null;
	}
}
