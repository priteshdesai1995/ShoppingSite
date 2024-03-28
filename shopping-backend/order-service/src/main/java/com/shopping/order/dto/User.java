package com.shopping.order.dto;

import lombok.Data;

@Data
public class User {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String email;
	private String role;
}
