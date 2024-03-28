package com.shopping.auth.database.runner;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shopping.auth.config.WebSecurityConfig;
import com.shopping.auth.entity.User;
import com.shopping.auth.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseRunner implements CommandLineRunner {

	Logger Log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private final UserService userService;
	private final PasswordEncoder passwordEncoder;

	private static final List<User> USERS = Arrays.asList(
			new User(1L, "admin", "admin", "Admin", "admin@mycompany.com", WebSecurityConfig.ADMIN),
			new User(2L, "user", "user", "User", "user@mycompany.com", WebSecurityConfig.USER));

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Log.info("Runner is  test: " + userService.getUsers().toString());
		
		if (!userService.getUsers().isEmpty()) {
			return;
		}
		
		USERS.forEach(user -> {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userService.saveUser(user);
		});
		log.info("Database initialized");
	}
}