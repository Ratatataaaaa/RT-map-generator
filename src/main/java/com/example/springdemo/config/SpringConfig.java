package com.example.springdemo.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.MultipartConfigElement;

@Configuration
@ComponentScan("com.example.springdemo")
@EnableWebMvc
public class SpringConfig implements WebMvcConfigurer {

	@Bean
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize(DataSize.parse("3MB"));
		multipartConfigFactory.setMaxRequestSize(DataSize.parse("3MB"));
		return multipartConfigFactory.createMultipartConfig();
	}
}
