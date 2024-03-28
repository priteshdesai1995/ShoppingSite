package com.shopping.product.mapper;

import com.shopping.product.dto.BrandDto;
import com.shopping.product.entity.Brand;

public interface BrandMapperService {
	Brand brandDtoToBrand(BrandDto brandDto);
}
