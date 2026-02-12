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

    // 1️⃣ Save Student
    public void saveStudent(Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(student);
        transaction.commit();
    }

    // 2️⃣ Find Student by ID
    public Student findStudentById(Long id) {
        return em.find(Student.class, id);
    }

    // 3️⃣ Find All Students
    public List<Student> findAllStudents() {
        return em.createQuery("SELECT s FROM Student s", Student.class)
                 .getResultList();
    }

    // 4️⃣ Update Student
    public void updateStudent(Student student) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(student);
        transaction.commit();
    }

    // 5️⃣ Delete Student
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
