package com.capg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class StudentDAO {

    private EntityManager em;

    // Constructor
    public StudentDAO(EntityManager em) {
        this.em = em;
    }

    // Save Student
    public void saveStudent(Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(student);
        transaction.commit();
    }

    // Find Student by ID
    public Student findStudentById(Long id) {
        return em.find(Student.class, id);
    }

    // Find All Students
    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                 .getResultList();
    }

    // Update Student
    public void updateStudent(Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(student);
        transaction.commit();
    }

    // Delete Student
    public void deleteStudent(Long id) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        transaction.commit();
    }
}
