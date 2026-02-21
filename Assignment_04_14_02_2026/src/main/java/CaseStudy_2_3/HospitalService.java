package CaseStudy_2_3;

import java.util.List;

public class HospitalService {

    PatientDAO patientDAO = new PatientDAO();
    DoctorDAO doctorDAO = new DoctorDAO();
    AppointmentDAO appointmentDAO = new AppointmentDAO();

    // Register patient with medical record
    public void registerPatientWithRecord(Patient p, MedicalRecord mr) {
        p.setMedicalRecord(mr);
        patientDAO.savePatient();
    }

    // Add multiple appointments to doctor
    public void addAppointmentsToDoctor(int doctorId, List<Appointment> list) {
        Doctor doctor = doctorDAO.findById(doctorId);
        if (doctor != null) {
            doctor.getAppointments().addAll(list);
            doctorDAO.deleteDoctor(doctor);
        }
    }

    // Assign appointment to patient
    public void assignAppointmentToPatient(int appointmentId, int patientId) {
        appointmentDAO.assignPatient(appointmentId, patientId);
    }

    // Update appointment fee
    public void updateAppointmentFee(int appointmentId, double fee) {
        appointmentDAO.updateFee(appointmentId, fee);
    }

    // Fetch doctor with appointments
    public Doctor fetchDoctorWithAppointments(int doctorId) {
        return doctorDAO.findById(doctorId);
    }

    // Delete patient
    public void deletePatient(int patientId) {
        patientDAO.deletePatient(patientId);
    }
}
