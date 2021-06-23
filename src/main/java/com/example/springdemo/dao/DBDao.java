package com.example.springdemo.dao;

import com.example.springdemo.model.rt.Student;

import java.util.Map;

public interface DBDao {

	Map<Integer, Student> getAllStudents();

	void add(Student student);

	void updateStudentById(Student student);

	Student getStudentById(int id);

	void deleteStudentById(int id);
}
