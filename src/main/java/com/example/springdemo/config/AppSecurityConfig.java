package com.example.springdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static com.example.springdemo.security.AppUserRole.*;


@Configuration
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AppSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.antMatchers("/", "index", "/css/*", "/js/*").permitAll()
				.antMatchers("/rt").hasRole(ADMIN.name())
				.antMatchers("/api").permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();

//				.formLogin()
//				.loginPage("/login").permitAll()
//				.defaultSuccessUrl("/rt", true)
//				.and()
//				.rememberMe();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails studentAnnaSmith = User.builder()
				.username("AnnaSmith")
				.password(passwordEncoder.encode("password"))
				.roles(STUDENT.name())
				.authorities(STUDENT.getGrantedAuthorities())
				.build();

		UserDetails someLindaLio = User.builder()
				.username("LindaLio")
				.password(passwordEncoder.encode("321"))
				.roles(ROLE.name())
				.authorities(ROLE.getGrantedAuthorities())
				.build();

		UserDetails adminTomOriginal = User.builder()
				.username("TomOriginal")
				.password(passwordEncoder.encode("123"))
				.roles(ADMIN.name())
				.authorities(ADMIN.getGrantedAuthorities())
				.build();

		return new InMemoryUserDetailsManager(
				studentAnnaSmith,
				someLindaLio,
				adminTomOriginal
		);

	}
}
