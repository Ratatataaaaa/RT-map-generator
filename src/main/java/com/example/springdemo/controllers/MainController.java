package com.example.springdemo.controllers;

import com.example.springdemo.models.Camera;
import com.example.springdemo.models.JsonModel;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Random;

@RequestMapping("/")
@Controller
@EnableWebMvc
public class MainController {

	@GetMapping("login")
	public String getInfo() {
		return "login";
	}

	@GetMapping("courses")
	public String getCourses() {
		return "courses";
	}

	@GetMapping("main")
	public String getMain() {
		return "main";
	}

}
