package com.shopping.auth.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.auth.config.TokenProvider;
import com.shopping.auth.config.WebSecurityConfig;
import com.shopping.auth.dto.AuthResponse;
import com.shopping.auth.dto.CheckRequest;
import com.shopping.auth.dto.LoginRequest;
import com.shopping.auth.dto.SignUpRequest;
import com.shopping.auth.dto.UserType;
import com.shopping.auth.entity.User;
import com.shopping.auth.exception.DuplicatedUserInfoException;
import com.shopping.auth.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
//allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header"
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UserAuthenticationController {

	Logger log = LoggerFactory.getLogger(getClass());

	private final UserService userService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final TokenProvider tokenProvider;

	@GetMapping(value = "/test")
	public ResponseEntity<List<String>> getHello() {
		log.info("Inside the Test API : " + userService.getUsers().toString());
		return ResponseEntity.status(HttpStatus.OK).body(Arrays.asList("test", "test2"));
	}

	@PostMapping("/authenticate")
	public AuthResponse login(@Valid @RequestBody LoginRequest loginRequest) {
		// , HttpServletResponse response
		// response.setHeader("Access-Control-Allow-Origin", "*");
		String token = authenticateAndGetToken(loginRequest.getUsername(), loginRequest.getPassword());
		return new AuthResponse(token);
	}

	@PostMapping(value = "/test")
	public AuthResponse getHelloPost() {
		String token = "helo";
		return new AuthResponse(token);
	}

	@PostMapping(value = "/test/{hello}")
	public AuthResponse getHelloPost(@PathVariable("hello") String helo) {
		String token = helo;
		return new AuthResponse(token);
	}

	@PostMapping(value = "/testbody", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AuthResponse getHelloPostTest(@RequestBody CheckRequest username) {
		return new AuthResponse(username.getUsername());
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/signup")
	public AuthResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
		if (userService.hasUserWithUsername(signUpRequest.getUsername())) {
			throw new DuplicatedUserInfoException(
					String.format("Username %s already been used", signUpRequest.getUsername()));
		}
		if (userService.hasUserWithEmail(signUpRequest.getEmail())) {
			throw new DuplicatedUserInfoException(
					String.format("Email %s already been used", signUpRequest.getEmail()));
		}

		userService.saveUser(mapSignUpRequestToUser(signUpRequest));

		String token = authenticateAndGetToken(signUpRequest.getEmail(), signUpRequest.getPassword());
		return new AuthResponse(token);
	}

	private String authenticateAndGetToken(String username, String password) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		return tokenProvider.generate(authentication);
	}

	private User mapSignUpRequestToUser(SignUpRequest signUpRequest) {
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setRole(UserType.valueOf(signUpRequest.getUserType()).toString());
		return user;
	}
}
