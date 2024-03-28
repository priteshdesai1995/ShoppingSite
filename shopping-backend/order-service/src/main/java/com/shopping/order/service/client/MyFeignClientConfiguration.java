package com.shopping.order.service.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class MyFeignClientConfiguration {
	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL; // Customize the Feign logging level
	}
}
