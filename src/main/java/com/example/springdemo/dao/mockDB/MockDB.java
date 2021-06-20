package com.example.springdemo.dao.mockDB;

import com.example.springdemo.dao.DBDao;
import com.example.springdemo.exception.StudentIOException;
import com.example.springdemo.model.Student;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MockDB implements DBDao {

	private static Map<Integer,Student> STUDENTS = new HashMap<>();

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
		if (STUDENTS.get(student.getStudentId()) != null) {
			throw new StudentIOException("Student with ID: " + student.getStudentId() + " already exist.");
		}
		STUDENTS.put(student.getStudentId(), student);
	}

	@Override
	public void updateStudentById(Student student) {
		if (STUDENTS.get(student.getStudentId()) == null) {
			throw new StudentIOException("Student with ID: " + student.getStudentId() + " not found.");
		}
		STUDENTS.put(student.getStudentId(), student);
	}

	@Override
	public Student getStudentById(int id) {
		if (STUDENTS.get(id) != null) {
			throw new StudentIOException("Student with ID: " + id + " not found.");
		}
		return STUDENTS.get(id);
	}

	@Override
	public void deleteStudentById(int id) {
		if (STUDENTS.get(id) == null) {
			throw new StudentIOException("Student with ID: " + id + " not found.");
		}
		STUDENTS.remove(id);
	}
}
