package com.example.springdemo.controller;

import com.example.springdemo.dao.DBDao;
import com.example.springdemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	DBDao dbDao;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
	public Map<Integer,Student> getAllStudents() {
		return dbDao.getAllStudents();
	}

	@GetMapping(path = "/{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer studentId) {
		return dbDao.getStudentById(studentId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('student:write')")
	public void registerNewStudent(@RequestBody Student student) {
		dbDao.add(student);
	}

	@DeleteMapping(path = "{studentId}")
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		dbDao.deleteStudentById(studentId);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@RequestBody Student student) {
		dbDao.updateStudentById(student);
	}

}
