package com.shopping.order.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class OrderItem extends BaseEntity {

	private static final long serialVersionUID = -1882499947253108697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long order_item_id;

	@ManyToOne
	@JoinColumn(name = "order_Id", referencedColumnName = "order_Id")
	Order order;

	@Column(name = "product_id")
	Long productId;

	@Column(name = "quantity")
	Long quantity;

	@Column(name = "unit_price")
	Long unitPrice;

	@Column(name = "subtotal")
	Long subtotal;
}
