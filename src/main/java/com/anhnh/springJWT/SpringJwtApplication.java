package com.anhnh.springJWT;

import com.anhnh.springJWT.domain.Role;
import com.anhnh.springJWT.domain.User;
import com.anhnh.springJWT.exception.CustomAccessDeniedHandler;
import com.anhnh.springJWT.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.util.ArrayList;

@SpringBootApplication
public class SpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveUser(new User(null, "Hoang Anh", "anhnh", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoang Anh 2", "anhnh2", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoang Anh 3", "anhnh3", "password", new ArrayList<>()));
			userService.saveUser(new User(null, "Hoang Anh 4", "anhnh4", "password", new ArrayList<>()));
			userService.addRoleToUser("anhnh", "ROLE_USER");
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
}
