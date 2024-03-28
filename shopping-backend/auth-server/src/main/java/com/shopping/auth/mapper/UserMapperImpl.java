package com.shopping.auth.mapper;

import org.springframework.stereotype.Service;

import com.shopping.auth.dto.UserDto;
import com.shopping.auth.entity.User;

@Service
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDto toUserDto(User user) {
		// TODO Auto-generated method stub
		if (user == null) {
			return null;
		}

		return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getRole());
	}

}
