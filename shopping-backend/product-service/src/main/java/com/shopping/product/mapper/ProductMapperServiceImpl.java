package com.shopping.product.mapper;

import org.springframework.stereotype.Service;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;

@Service
public class ProductMapperServiceImpl implements ProductMapperService {

	@Override
	public Product productDtoToProduct(ProductDto productDto) {
		Product product = new Product();
		product.setProductName(productDto.getProductName());
		product.setProductDescription(productDto.getProductDescription());
		product.setProductPrice(productDto.getProductPrice());
		product.setStockQuantity(productDto.getStockQuantity());
		product.setDiscountedPrice(productDto.getDiscountedPrice());
		if (productDto.getCategory() != null)
			product.setCategory(productDto.getCategory());
		if (productDto.getBrand() != null)
			product.setBrand(productDto.getBrand());
		return product;
	}

}
