package com.shopping.order.service.client;

import org.springframework.stereotype.Component;

import com.shopping.order.dto.UserDto;

@Component
public class UserFallback implements UserFeignClient {

	@Override
	public UserDto getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
