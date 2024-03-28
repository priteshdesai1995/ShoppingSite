package com.shopping.order.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.dto.UserDto;
import com.shopping.order.entity.Order;
import com.shopping.order.mapper.OrderDtoToOrderMapper;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.service.OrderService;
import com.shopping.order.service.client.UserFeignClient;

@Service
public class OrderServiceImpl implements OrderService {

	Logger Log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	OrderDtoToOrderMapper dtoToOrderMapper;

	@Autowired
	UserFeignClient userFeignClient;

	@Override
	public Optional<Order> createOrder(OrderDto orderDto) {
		UserDto user = userFeignClient.getUser("Admin");
		Log.info("user is : " + user.toString());
		
		
		Order order = dtoToOrderMapper.orderDtoToOrderMapper(orderDto);
		return Optional.of(orderRepository.save(order));
	}

}
