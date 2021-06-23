package com.example.springdemo.dao.mockDB;

import com.example.springdemo.dao.DBDao;
import com.example.springdemo.model.rt.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MockDB implements DBDao {

	private static final Map<Integer, Student> STUDENTS = new HashMap<>();

	{
		STUDENTS.put(1, new Student(1, "James Bond"));
		STUDENTS.put(2, new Student(2, "Maria Jones"));
		STUDENTS.put(3, new Student(3, "Anna Smith"));
	}

	@Override
	public Map<Integer, Student> getAllStudents() {
		return STUDENTS;
	}

	@Override
	public void add(Student student) {

	}

	@Override
	public void updateStudentById(Student student) {

	}

	@Override
	public Student getStudentById(int id) {
		return new Student(0, "Mock Student");
	}

	@Override
	public void deleteStudentById(int id) {

	}
}
