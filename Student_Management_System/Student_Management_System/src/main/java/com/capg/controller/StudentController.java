package com.capg.controller;

import com.capg.entity.Student;
import com.capg.service.StudentService;

public class StudentController {
	
	private static StudentService service = new StudentService();
	
	public static void main(String[] args) {
		service.registerStudent("ABC", 99, 35.55);
		service.registerStudent("DEF", 21, 57.63);
		
//		service.updateMarks(2, 55.55);
//		
//		Student student=service.getStudent(2);
//		System.out.println(student);
//		
//		service.deleteStudent(2);		
	}

}
