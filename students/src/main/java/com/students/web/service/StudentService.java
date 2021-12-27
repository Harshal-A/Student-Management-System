package com.students.web.service;

import java.util.List;

import com.students.web.entity.Student;

public interface StudentService {

	public List<Student> getAllStudents();
	
	public void saveStudent(Student s);
	
	public Student updateStudent(Student s);
	
	public Student getSudentById(int id);
	
	public void delete(int id);
}
