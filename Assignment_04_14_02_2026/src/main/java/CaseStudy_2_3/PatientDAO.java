package CaseStudy_2_3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PatientDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    // save patient passed from service
    public void savePatient(Patient patient) {

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(patient);
        et.commit();
    }

    // find patient by id
    public Patient findById(int id) {
        return em.find(Patient.class, id);
    }

    // update patient
    public void updatePatient(int id, String newName, long newContact) {

        EntityTransaction et = em.getTransaction();
        Patient patient = em.find(Patient.class, id);

        if (patient != null) {
            et.begin();
            patient.setName(newName);
            patient.setContact(newContact);
            et.commit();
        }
    }

    // delete patient
    public void deletePatient(int id) {

        EntityTransaction et = em.getTransaction();
        Patient patient = em.find(Patient.class, id);

        if (patient != null) {
            et.begin();
            em.remove(patient);
            et.commit();
        }
    }
}
