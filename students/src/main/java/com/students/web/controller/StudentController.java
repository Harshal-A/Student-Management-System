package com.students.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/new")
	public String addNewStudent(Model model) {
		Student student=new Student();
		model.addAttribute("student", student);
		return "create-student";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable int id, Model model) {
		Student s=studentService.getSudentById(id);
		model.addAttribute("student", s);
		return "edit-student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student,Model model) {
		Student s=studentService.getSudentById(id);
		s.setId(id);
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		s.setEmail(student.getEmail());
		studentService.updateStudent(s);
		return "redirect:/students";
	}
	
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.delete(id);
		return "redirect:/students";
	}
	
	
}
