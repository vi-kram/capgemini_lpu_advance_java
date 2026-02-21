package com.capg.service;

import com.capg.dao.CourseDao;
import com.capg.entity.Course;

public class CourseService {

    private CourseDao dao = new CourseDao();

    public Course addCourse(String name, String trainer) {
        if(name == null) {
            throw new IllegalArgumentException("Invalid Entry");
        }
        if(trainer == null) {
            throw new IllegalArgumentException("Invalid Entry");
        }
        Course course = new Course(name, trainer);
        return dao.saveCourse(course);
    }

    public Course getCourse(int id) {
        Course c = dao.findCourseById(id);
        if (c == null) {
            throw new IllegalArgumentException("Course not found");
        }
        return c;
    }

    public void updateTrainer(int id, String newTrainer) {
        if (newTrainer == null) {
            throw new IllegalArgumentException("Invalid Entry");
        }
        dao.updateTrainer(id, newTrainer);
    }

    public void deleteCourse(int id) {
        dao.deleteCourseById(id);
    }
}