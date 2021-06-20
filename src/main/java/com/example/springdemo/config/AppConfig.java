package com.example.springdemo.config;

import com.example.springdemo.dao.DBDao;
import com.example.springdemo.dao.mockDB.MockDB;
import com.example.springdemo.service.RTService;
import com.example.springdemo.service.impl.RTServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.MultipartConfigElement;

@Configuration
@ComponentScan("com.example.springdemo")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {

	private final ApplicationContext applicationContext;

	@Autowired
	public AppConfig(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("classpath:/htmls/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
		multipartConfigFactory.setMaxFileSize(DataSize.parse("10MB"));
		multipartConfigFactory.setMaxRequestSize(DataSize.parse("10MB"));
		return multipartConfigFactory.createMultipartConfig();
	}

	@Bean
	RTService rtService() {
		return new RTServiceImpl();
	}

	@Bean
	DBDao dbDao() {
		return new MockDB();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}
}
