package com.capg.dao;

import com.capg.entity.Course;
import com.capg.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentDao {
	
	private EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	
	public Student saveStudent(Student s) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
		
		em.close();
		return s;
	}
	
	public void updateStudentMarks(int id, double newMarks) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		//Student student=findStudentById(id);    we can not just call the function as we are closing the entitymanager
		Student student=em.find(Student.class, id);
		
		et.begin();
		if(student != null) {   //null verification
			student.setMarks(newMarks);
			em.merge(student);
		}
		et.commit();
		
		em.close();
	}
	
	public Student findStudentById(int id) {
		EntityManager em=emf.createEntityManager();
		
		Student student=em.find(Student.class, id);
		
		em.close();
		return student;
	}
	
	public void deleteStudentById(int id) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Student student=em.find(Student.class, id);
		
		et.begin();
		if(student != null)   //null verification
			em.remove(student);
		et.commit();
		
		em.close();
	}
	
	public void giveCourseToStudent(int studentId, int courseId) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();

	    Student student = em.find(Student.class, studentId);
	    Course course = em.find(Course.class, courseId);

	    et.begin();
	    if(student!=null && course!=null) {
	        student.getCourse().add(course);
	    }
	    et.commit();
	    
	    em.close();
	}
}
