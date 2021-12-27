package com.students.web.service;

import java.util.List;

import com.students.web.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public void saveStudent(Student s);
}
