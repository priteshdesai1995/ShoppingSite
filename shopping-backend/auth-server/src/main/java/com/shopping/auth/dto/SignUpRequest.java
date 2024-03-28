package com.shopping.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpRequest {

	@NotBlank
	private String username;

	@NotBlank
	private String password;

	@NotBlank
	private String name;

	@Email
	private String email;
	
	@NotBlank
	private String userType;
}
