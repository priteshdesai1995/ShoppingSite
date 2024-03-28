package com.shopping.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	private String productName;

	private String productDescription;

	private Long productPrice;

	private Long discountedPrice;

	private Long stockQuantity;

	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "categoryId")
	private Category category;
}
