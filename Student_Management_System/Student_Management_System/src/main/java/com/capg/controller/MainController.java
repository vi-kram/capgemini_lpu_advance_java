package com.capg.controller;

import com.capg.service.CourseService;
import com.capg.service.StudentService;

public class MainController {

    public static void main(String[] args) {

        StudentService s = new StudentService();
        CourseService c = new CourseService();

        c.addCourse("Java", "Ravi");
        c.addCourse("SQL", "Vaishnav");

        s.registerStudent("ABC", 99, 35.55);
		s.registerStudent("DEF", 21, 57.63);

        s.giveCourseToStudent(1, 1);
        s.giveCourseToStudent(1, 2);
        s.giveCourseToStudent(2, 1);
        s.giveCourseToStudent(2, 2);
    }
}