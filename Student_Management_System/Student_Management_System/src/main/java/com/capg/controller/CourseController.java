package com.capg.controller;

import com.capg.entity.Course;
import com.capg.service.CourseService;

public class CourseController {
	
	private static CourseService service = new CourseService();
	
	public static void main(String[] args) {
		service.addCourse("Java", "Ravi");
		service.addCourse("SQL", "Vaishnav");
		
//		service.updateTrainer(1, "Sandeep");
//		
//		Course course=service.getCourse(1);
//		System.out.println(course);
//		
//		service.deleteCourse(1);
		
	}

}
