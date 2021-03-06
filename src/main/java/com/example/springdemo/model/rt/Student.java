package com.example.springdemo.model.rt;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {

	private final Integer studentId;
	private final String studentName;

	public Student(@JsonProperty("studentId") Integer studentId,
	               @JsonProperty("studentName") String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	@Override
	public String toString() {
		return "Student {\n" +
				"studentId: " + studentId + ",\n" +
				"studentName: " + studentName + "\n" +
				'}';
	}
}
