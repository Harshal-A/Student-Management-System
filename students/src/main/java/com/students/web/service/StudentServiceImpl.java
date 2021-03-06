package com.students.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.web.entity.Student;
import com.students.web.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studRepository) {
	this.studentRepository=studRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void saveStudent(Student s) {
		studentRepository.save(s);
		
	}


	@Override
	public Student getSudentById(int id) {
		return studentRepository.getById(id);
	}


	@Override
	public Student updateStudent(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public void delete(int id) {
		studentRepository.deleteById(id);
	}
}
