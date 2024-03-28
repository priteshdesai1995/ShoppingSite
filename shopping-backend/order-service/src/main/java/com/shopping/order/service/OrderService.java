package com.shopping.order.service;

import java.util.Optional;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.entity.Order;

public interface OrderService {
	Optional<Order> createOrder(OrderDto orderDto);
}
