package com.students.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.web.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
