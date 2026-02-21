package com.capg.service;

import com.capg.dao.StudentDao;
import com.capg.entity.Student;

public class StudentService {
	
	private StudentDao dao = new StudentDao();
	
	public Student registerStudent(String name, int age, double marks) {
		if(age<18 || age>100) {
			throw new IllegalArgumentException("Invalid Entry");
		}
		if(marks<0 || marks>100) {
			throw new IllegalArgumentException("Invalid Entry");
		}
		Student student = new Student(name, age, marks);
		return dao.saveStudent(student);
	}
	
	public void giveCourseToStudent(int studentId, int courseId) {
        dao.giveCourseToStudent(studentId, courseId);
    }
	
	public Student getStudent(int id) {
		Student s = dao.findStudentById(id);
		if(s==null) {
			throw new IllegalArgumentException("Student not found");
		}
		return s;
	}
	
	public void updateMarks(int id, double newMarks) {
		if(newMarks<0 || newMarks>100) {
			throw new IllegalArgumentException("Invalid Entry");
		}
		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id) {
		dao.deleteStudentById(id);
	}
}
