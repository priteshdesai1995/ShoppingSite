package com.shopping.order.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order.dto.OrderItemDto;
import com.shopping.order.entity.OrderItem;
import com.shopping.order.service.OrderItemService;

@RestController
@RequestMapping(value = "/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderService;

	@PostMapping
	public OrderItem createOrderItem(@RequestBody OrderItemDto orderItemDto) {
		Optional<OrderItem> orders = orderService.createOrderItem(orderItemDto);
		return orders.get();
	}
}
