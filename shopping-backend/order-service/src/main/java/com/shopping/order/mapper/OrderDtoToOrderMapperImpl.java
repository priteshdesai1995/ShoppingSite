package com.shopping.order.mapper;

import org.springframework.stereotype.Service;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.entity.Order;

@Service
public class OrderDtoToOrderMapperImpl implements OrderDtoToOrderMapper {

	@Override
	public Order orderDtoToOrderMapper(OrderDto orderDto) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setUserId(orderDto.getUserId());
		order.setOrderDate(orderDto.getOrderDate());
		order.setOrderStatus(orderDto.getOrderStatus());
		order.setTotalAmount(orderDto.getTotalAmount());
		order.setPaymentMethod(orderDto.getPaymentMethod());
		order.setShippingAddress(orderDto.getShippingAddress());
		return order;
	}

}
