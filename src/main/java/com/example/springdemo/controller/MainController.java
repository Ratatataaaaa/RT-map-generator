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

	@GetMapping("main")
	public String getCourses() {
		return "main";
	}

	@GetMapping("students")
	public String getStudent() {
		return "students";
	}

	@GetMapping("rt")
	public String getMain() {
		return "rt";
	}

}
