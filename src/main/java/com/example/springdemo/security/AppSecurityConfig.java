package com.example.springdemo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static com.example.springdemo.security.AppUserRole.ADM;
import static com.example.springdemo.security.AppUserRole.LOX;

@Configuration
@EnableWebMvc
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AppSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/api/**").hasRole(ADM.name())
				.anyRequest()
				.authenticated()
				.and()
				.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails myBeach = User.builder()
				.username("user")
				.password(passwordEncoder.encode("pass123"))
				.roles(LOX.name())
				.build();

		UserDetails linda = User.builder()
				.username("linda")
				.password(passwordEncoder.encode("pass"))
				.roles(ADM.name())
				.build();

		return new InMemoryUserDetailsManager(
				myBeach,
				linda);
	}
}
