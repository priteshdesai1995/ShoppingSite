package com.shopping.gateway.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TokenValidateUtil {

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	public void validateToken(String authHeaderToken) {
		// TODO Auto-generated method stub
		System.out.println("jwtSecret : " + jwtSecret);

		byte[] signingKey = jwtSecret.getBytes();
		Jwts.parser().verifyWith(Keys.hmacShaKeyFor(signingKey)).build().parseSignedClaims(authHeaderToken);
	}

}
