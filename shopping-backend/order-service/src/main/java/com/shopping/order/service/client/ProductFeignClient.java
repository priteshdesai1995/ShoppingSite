package com.shopping.order.service.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "cards", fallback = ProductFallback.class)
public interface ProductFeignClient {

}
