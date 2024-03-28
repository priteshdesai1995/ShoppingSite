package com.shopping.product.service;

import java.util.Optional;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;

public interface ProductService {
	Optional<Product> createProduct(ProductDto productDto);
}
