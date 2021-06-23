package com.example.springdemo.controller;

import com.example.springdemo.dao.DBDao;
import com.example.springdemo.model.rt.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	DBDao dbDao;

	@GetMapping(value = "/all")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public Map<Integer, Student> getAllStudents() {
		log.info("User: {} getAllStudents", SecurityContextHolder.getContext().getAuthentication().getName());
		return dbDao.getAllStudents();
	}

	@GetMapping
	public Student getStudent(@RequestParam("studentId") Integer studentId) {
		log.info("User: {} getStudent", SecurityContextHolder.getContext().getAuthentication().getName());
		return dbDao.getStudentById(studentId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@PreAuthorize("hasAuthority('student:write')")
	public void registerNewStudent(@ModelAttribute Student student) {
		log.info("User: {} registerNewStudent", SecurityContextHolder.getContext().getAuthentication().getName());
		dbDao.add(student);
		log.info("New Student: {} added", student);
	}

	@DeleteMapping(path = "{studentId}")
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@PreAuthorize("hasAuthority('student:write')")
	public void deleteStudent(@PathVariable("studentId") Integer studentId) {
		log.info("User: {} deleteStudent", SecurityContextHolder.getContext().getAuthentication().getName());
		dbDao.deleteStudentById(studentId);
		log.info("Student with Id: {} deleted", studentId);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	@PreAuthorize("hasAuthority('student:write')")
	public void updateStudent(@RequestBody Student student) {
		log.info("User: {} updateStudent", SecurityContextHolder.getContext().getAuthentication().getName());
		dbDao.updateStudentById(student);
		log.info("Student with Id: {} update", student.getStudentId());
	}

}
