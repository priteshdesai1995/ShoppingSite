package com.shopping.order.entity;

import java.time.LocalDateTime;

import com.shopping.order.util.OrderStatus;
import com.shopping.order.util.PaymentMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ProductOrder")
public class Order extends BaseEntity {

	private static final long serialVersionUID = -7150874918372353875L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_Id")
	private Long orderId;

//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
//	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "order_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime orderDate;

	@Column(name = "total_amount")
	private Long totalAmount;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status")
	private OrderStatus orderStatus;

	@Column(name = "shipping_address")
	private String shippingAddress;

	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;
}
