package com.shopping.auth.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.auth.dto.CustomUserDetails;
import com.shopping.auth.dto.UserDto;
import com.shopping.auth.entity.User;
import com.shopping.auth.mapper.UserMapper;
import com.shopping.auth.service.UserService;

import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService;
	private final UserMapper userMapper;

	@GetMapping(value = "/test")
	public ResponseEntity<List<String>> getHello() {
		return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("test", "test2"));
	}

	@GetMapping("/numberOfUsers")
	public Integer getNumberOfUsers() {
		return userService.getUsers().size();
	}

	@GetMapping("/me")
	public UserDto getCurrentUser(@AuthenticationPrincipal CustomUserDetails currentUser) {
		return userMapper.toUserDto(userService.validateAndGetUserByUsername(currentUser.getUsername()));
	}

	@GetMapping
	public List<UserDto> getUsers() {
		return userService.getUsers().stream().map(userMapper::toUserDto).collect(Collectors.toList());
	}

	@GetMapping("/{username}")
	public UserDto getUser(@PathVariable String username) {
		return userMapper.toUserDto(userService.validateAndGetUserByUsername(username));
	}

	@DeleteMapping("/{username}")
	public UserDto deleteUser(@PathVariable String username) {
		User user = userService.validateAndGetUserByUsername(username);
		userService.deleteUser(user);
		return userMapper.toUserDto(user);
	}
}
