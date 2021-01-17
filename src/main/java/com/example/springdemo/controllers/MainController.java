package com.example.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	@GetMapping("/")
	public String start(@RequestParam(name="Server") String server,Model model) {
		model.addAttribute("title", "Home page.");
		model.addAttribute("server", server);
		return "start";
	}

	@GetMapping("/hello")
	public String helloPage() {
		return "hello";
	}

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "goodbye";
	}

	@GetMapping("/exit")
	public String exit() {
		return "exit";
	}
}
