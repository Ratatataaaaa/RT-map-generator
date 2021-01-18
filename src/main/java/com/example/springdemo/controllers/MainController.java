package com.example.springdemo.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping("/")
	public String start(@RequestParam(name="Server") String server, Model model) {
		model.addAttribute("title", "Home page.");
		model.addAttribute("server", server);
		return "resources/templates/start";
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

	@GetMapping("/calculator")
	public String calculator(@RequestParam("a") int a,
	                         @RequestParam("b") int b,
	                         @RequestParam("action") String action,
	                         Model model) {
		double      result;
		switch (action) {
			case "/":
				result = (double)a / b;
				break;
			case "*":
				result = a * b;
				break;
			case "+":
				result = a + b;
				break;
			case "-":
				result = a - b;
				break;
			default:
				result = 0;
				break;
		}
		model.addAttribute("result", result);
		return "calculator";
	}

}
