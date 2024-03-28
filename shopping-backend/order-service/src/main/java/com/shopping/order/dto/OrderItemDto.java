package com.shopping.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shopping.order.entity.Order;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDto {
	Order order;

	Long productId;

	Long quantity;

	Long unitPrice;

	Long subtotal;
}
