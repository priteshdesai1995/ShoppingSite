package com.shopping.carousal.mapper;

import com.shopping.carousal.dto.CarousalDTO;
import com.shopping.carousal.entity.CarousalProduct;

public class CarousalMapper {
	public static CarousalProduct mapToEntity(CarousalDTO carousalDTO) {
		return new CarousalProduct(carousalDTO.getId(), carousalDTO.getCarousalType(), carousalDTO.getUrl(),
				carousalDTO.getPath(), carousalDTO.getSourceType());
	}

	public static CarousalDTO mapToDTO(CarousalProduct carousalDTO) {
		return new CarousalDTO(carousalDTO.getId(), carousalDTO.getCarousalType(), carousalDTO.getUrl(),
				carousalDTO.getPath(), carousalDTO.getSourceType());
	}
}
