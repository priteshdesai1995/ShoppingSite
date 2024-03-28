package com.shopping.gateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.shopping.gateway.util.TokenValidateUtil;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, allowedHeaders = "*", allowCredentials = "true")
@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {
	
	Logger Log = LoggerFactory.getLogger(getClass());

	@Autowired
	private RouteValidator validator;

	@Autowired
	TokenValidateUtil tokenValidateUtil;
	
	public static class Config {

	}

	public AuthenticationFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		Log.info("Authentication Filter is Called");
		return ((exchange, chain) -> {
			Log.info("request is : " + exchange.getRequest().getPath());
			Log.info(validator.isSecured.test(exchange.getRequest()) ? "true" : "false");
			if (validator.isSecured.test(exchange.getRequest())) {
				// header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try {
//                    //REST call to AUTH service
//                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
					tokenValidateUtil.validateToken(authHeader);

				} catch (Exception e) {
					Log.error(e.getMessage());
					System.out.println("invalid access...!");
					throw new RuntimeException("un authorized access to application");
				}
			}
			return chain.filter(exchange);
		});
	}
}
