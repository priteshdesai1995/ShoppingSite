package com.shopping.order.mapper;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.entity.Order;

public interface OrderDtoToOrderMapper {
	Order orderDtoToOrderMapper(OrderDto orderDto);
}
