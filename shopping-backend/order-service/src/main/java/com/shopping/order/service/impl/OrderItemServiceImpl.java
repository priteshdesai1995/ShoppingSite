package com.shopping.order.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.order.dto.OrderItemDto;
import com.shopping.order.entity.OrderItem;
import com.shopping.order.mapper.OrderItemDtoToOrderItemMapper;
import com.shopping.order.repository.OrderItemRepository;
import com.shopping.order.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	OrderItemRepository itemRepository;

	@Autowired
	OrderItemDtoToOrderItemMapper dtoToOrderItemMapper;

	@Override
	public Optional<OrderItem> createOrderItem(OrderItemDto orderItemDto) {
		OrderItem orderItem = dtoToOrderItemMapper.orderItemDtoToOrderItemMapper(orderItemDto);
		return Optional.of(itemRepository.save(orderItem));
	}

}
