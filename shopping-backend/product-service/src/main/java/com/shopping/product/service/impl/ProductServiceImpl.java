package com.shopping.product.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;
import com.shopping.product.mapper.ProductMapperService;
import com.shopping.product.repository.ProductRepository;
import com.shopping.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductMapperService mapperService;

	@Override
	public Optional<Product> createProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Product product = mapperService.productDtoToProduct(productDto);
		return Optional.of(productRepository.save(product));
	}

}
