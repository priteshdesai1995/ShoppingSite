package com.shopping.carousal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarousalDTO {
	private Long Id;

	private String carousalType;

	private String url;

	private String path;

	private String sourceType;
}
