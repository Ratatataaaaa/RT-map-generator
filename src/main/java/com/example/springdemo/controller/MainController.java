package com.example.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("login")
	public String getInfo() {
		return "login";
	}

	@GetMapping("courses")
	public String getCourses() {
		return "courses";
	}

	@GetMapping("student")
	public String getStudent() {
		return "student";
	}

	@GetMapping("rt")
	public String getMain() {
		return "rt";
	}

}
