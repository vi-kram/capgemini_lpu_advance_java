package com.capg.dao;

import com.capg.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CourseDao {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");

    public Course saveCourse(Course c) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(c);
        et.commit();
        
        em.close();
        return c;
    }

    public void updateTrainer(int id, String newTrainer) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Course course = em.find(Course.class, id);

        et.begin();
        if (course != null) {
            course.setTrainer(newTrainer);
            em.merge(course); 
        }
        et.commit();
        
        em.close();
    }

    public Course findCourseById(int id) {
        EntityManager em = emf.createEntityManager();
        
        Course course = em.find(Course.class, id);
        
        em.close();
        return course;
    }

    public void deleteCourseById(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Course course = em.find(Course.class, id);

        et.begin();
        if (course != null) {
            em.remove(course);
        }
        et.commit();
        
        em.close();
    }
}