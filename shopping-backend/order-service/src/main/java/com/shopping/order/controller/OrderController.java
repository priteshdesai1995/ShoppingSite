package com.shopping.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.entity.Order;
import com.shopping.order.service.OrderService;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping
	public Order createOrder(@RequestBody OrderDto dto) {
		Optional<Order> order = orderService.createOrder(dto);
		return order.get();
	}

}
