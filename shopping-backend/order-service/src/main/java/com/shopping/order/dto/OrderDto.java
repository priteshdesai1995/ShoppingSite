package com.shopping.order.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping.order.util.OrderStatus;
import com.shopping.order.util.PaymentMethod;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

	private Long userId;

	private LocalDateTime orderDate;

	private Long totalAmount;

	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	private String shippingAddress;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;
}
