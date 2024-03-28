package com.shopping.auth.mapper;

import com.shopping.auth.dto.UserDto;
import com.shopping.auth.entity.User;

public interface UserMapper {
	UserDto toUserDto(User user);
}
