package com.shopping.product.mapper;

import org.springframework.stereotype.Service;

import com.shopping.product.dto.BrandDto;
import com.shopping.product.entity.Brand;

@Service
public class BrandMapperServiceImpl implements BrandMapperService {

	public Brand brandDtoToBrand(BrandDto brandDto) {
		Brand brand = new Brand();
		brand.setBrandName(brandDto.getBrandName());
		brand.setDescription(brandDto.getDescription());
		return brand;
	}
}
