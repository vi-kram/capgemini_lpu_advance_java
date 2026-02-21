package CaseStudy_2_3;

import java.time.LocalDate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AppointmentDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    EntityManager em = emf.createEntityManager();

    // this is used to insert appointment detail into the table
    public void saveAppointment() {

        EntityTransaction et = em.getTransaction();

        Appointment appointment = new Appointment();
        appointment.setId(301);
        appointment.setVisitDate(LocalDate.now());
        appointment.setFee(500);

        et.begin();
        em.persist(appointment);
        et.commit();
    }

    // this method is used to find appointment by id
    public Appointment findById(int id) {
        return em.find(Appointment.class, id);
    }

    // this method is used to update appointment fee
    public void updateFee(int id, double newFee) {

        EntityTransaction et = em.getTransaction();

        Appointment appointment = em.find(Appointment.class, id);

        if (appointment != null) {
            et.begin();
            appointment.setFee(newFee);
            et.commit();
        }

        em.close();
    }

    // this method is used to assign appointment to patient (ManyToOne)
    public void assignPatient(int appointmentId, int patientId) {

        EntityTransaction et = em.getTransaction();

        Appointment appointment = em.find(Appointment.class, appointmentId);
        Patient patient = em.find(Patient.class, patientId);

        if (appointment != null && patient != null) {
            et.begin();
            appointment.setPatient(patient);
            et.commit();
        }

        em.close();
    }

    // this method is used to delete appointment by id
    public void deleteAppointment(int id) {

        EntityTransaction et = em.getTransaction();

        Appointment appointment = em.find(Appointment.class, id);

        if (appointment != null) {
            et.begin();
            em.remove(appointment);
            et.commit();
        }

        em.close();
    }

	public void assignPatient(int appointmentId, int patientId) {
		// TODO Auto-generated method stub
		
	}

	public void updateFee(int appointmentId, double fee) {
		// TODO Auto-generated method stub
		
	}
}

