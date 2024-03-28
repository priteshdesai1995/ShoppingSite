package com.shopping.product.mapper;

import com.shopping.product.dto.ProductDto;
import com.shopping.product.entity.Product;

public interface ProductMapperService {
	Product productDtoToProduct(ProductDto productDto);
}
