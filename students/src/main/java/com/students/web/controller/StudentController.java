package com.students.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.students.web.entity.Student;
import com.students.web.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	
	public StudentController(StudentService stuService) {
		this.studentService=stuService;
	}
	
	@GetMapping("/students")
	public String getAllStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String addNewStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create-student";
	}
	
}
