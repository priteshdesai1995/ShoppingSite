package com.shopping.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
