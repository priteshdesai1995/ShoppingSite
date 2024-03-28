package com.shopping.auth.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	private final TokenAuthenticationFilterPerRequest tokenAuthenticationFilter;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(
						authorizeHttpRequests -> authorizeHttpRequests.requestMatchers(HttpMethod.GET, "/api/users/me")
								.hasAnyAuthority(ADMIN, USER).requestMatchers("/api/users", "/api/users/**")
								.hasAuthority(ADMIN).requestMatchers("/public/**", "/auth/**", "/test/**").permitAll()
								.requestMatchers("/**", "/", "/error", "/csrf", "/cors", "/swagger-ui.html",
										"/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**", "/actuator/**")
								.permitAll()
								.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.OPTIONS, "/**"))
								.permitAll().anyRequest().authenticated())
				.addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.exceptionHandling(exceptionHandling -> exceptionHandling
						.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
				.sessionManagement(
						sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(AbstractHttpConfigurer::disable)
//				.cors(AbstractHttpConfigurer::disable)
//				.cors(Customizer.withDefaults())
//				.cors(c -> c.configurationSource(corsConfigurationSource()))
//				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.build();
	}

//	private CorsConfigurationSource corsConfigurationSource() {
//		return new CorsConfigurationSource() {
//			
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				CorsConfiguration cfg = new CorsConfiguration();
//				cfg.setAllowedOrigins(Arrays.asList("*"));
//				cfg.setAllowedMethods(Collections.singletonList("*"));
//				cfg.setAllowedHeaders(Collections.singletonList("*"));
//				cfg.setExposedHeaders(List.of("Authorization"));
//				cfg.setAllowCredentials(true);
//				cfg.setMaxAge(3600L);
//				return cfg;
//			}
//		};
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static final String ADMIN = "ADMIN";
	public static final String USER = "USER";
}
