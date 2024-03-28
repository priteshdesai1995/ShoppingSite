package com.shopping.order.mapper;

import org.springframework.stereotype.Service;

import com.shopping.order.dto.OrderItemDto;
import com.shopping.order.entity.OrderItem;

@Service
public class OrderItemDtoToOrderItemMapperImpl implements OrderItemDtoToOrderItemMapper {

	@Override
	public OrderItem orderItemDtoToOrderItemMapper(OrderItemDto orderItemDto) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrder(orderItemDto.getOrder());
		orderItem.setProductId(orderItemDto.getProductId());
		orderItem.setQuantity(orderItemDto.getQuantity());
		orderItem.setSubtotal(orderItemDto.getSubtotal());
		orderItem.setUnitPrice(orderItemDto.getUnitPrice());
		return orderItem;
	}

}
