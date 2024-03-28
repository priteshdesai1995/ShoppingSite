package com.shopping.product.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;
import com.shopping.product.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping
	public Product createProduct(@RequestBody ProductDto productDto) {
		Optional<Product> product = productService.createProduct(productDto);
		return product.get();
	}
}
