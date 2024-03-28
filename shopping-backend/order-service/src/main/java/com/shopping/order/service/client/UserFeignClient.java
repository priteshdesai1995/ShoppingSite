package com.shopping.order.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shopping.order.dto.UserDto;

@FeignClient(value = "gateway", fallback = UserFallback.class, path = "authserver", configuration = MyFeignClientConfiguration.class)
public interface UserFeignClient {

	@GetMapping(value = "api/users/{username}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDto getUser(@PathVariable String username);
}
