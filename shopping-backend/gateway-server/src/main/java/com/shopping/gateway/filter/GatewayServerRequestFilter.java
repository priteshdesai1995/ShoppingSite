package com.shopping.gateway.filter;

import java.io.IOException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class GatewayServerRequestFilter extends OncePerRequestFilter {
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, enctype");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		if (HttpMethod.OPTIONS.name().equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			filterChain.doFilter(req, res);
//		}
//	}
//}

//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class GatewayServerRequestFilter implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		HttpServletRequest request = (HttpServletRequest) req;
//		HttpServletResponse response = (HttpServletResponse) res;
//		response.setHeader("Access-Control-Allow-Origin", "*");
//		response.setHeader("Access-Control-Allow-Credentials", "true");
//		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
//		response.setHeader("Access-Control-Max-Age", "3600");
//		if (HttpMethod.OPTIONS.name().equalsIgnoreCase((request.getMethod()))) {
//			response.setStatus(HttpServletResponse.SC_OK);
//		} else {
//			chain.doFilter(req, res);
//		}
//	}
//}
