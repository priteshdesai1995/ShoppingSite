package com.shopping.order.mapper;

import com.shopping.order.dto.OrderItemDto;
import com.shopping.order.entity.OrderItem;

public interface OrderItemDtoToOrderItemMapper {
	OrderItem orderItemDtoToOrderItemMapper(OrderItemDto orderItemDto);
}
