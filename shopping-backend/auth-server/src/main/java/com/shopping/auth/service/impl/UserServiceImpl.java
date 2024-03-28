package com.shopping.auth.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.shopping.auth.entity.User;
import com.shopping.auth.exception.UserNotFoundException;
import com.shopping.auth.repository.UserRepository;
import com.shopping.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	Logger Log = LoggerFactory.getLogger(getClass());
	
	private final UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		Log.info("UserServiceImpl User List is : " + userRepository.findAll().toString());
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean hasUserWithUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public User validateAndGetUserByUsername(String username) {
		return getUserByUsername(username).orElseThrow(
				() -> new UserNotFoundException(String.format("User with username %s not found", username)));
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public Optional<User> getUserByUserEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

}
