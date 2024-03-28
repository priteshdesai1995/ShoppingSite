package com.shopping.order.service;

import java.util.Optional;

import com.shopping.order.dto.OrderItemDto;
import com.shopping.order.entity.OrderItem;

public interface OrderItemService {
	Optional<OrderItem> createOrderItem(OrderItemDto orderItemDto);
}
