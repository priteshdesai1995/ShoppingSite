package com.shopping.gateway;

import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.http.protocol.HTTP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.filter.factory.DedupeResponseHeaderGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import com.shopping.gateway.config.AuthenticationFilter;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator eazyBankRouteConfig(RouteLocatorBuilder routeLocatorBuilder,
			AuthenticationFilter authenticationFilter) {
		return routeLocatorBuilder.routes()
				.route(p -> p.path("/shopping/carousal/**")
						.filters(f -> f.rewritePath("/shopping/carousal/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.circuitBreaker(config -> config.setName("carousalCircuitBreaker")
										.setFallbackUri("forward:/contactSupport"))
								.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
						.uri("lb://CAROUSAL"))

				.route(p -> p.path("/shopping/auth/**")
						.filters(f -> f.rewritePath("/shopping/auth/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.retry(retryConfig -> retryConfig.setRetries(3)
										.setMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
										.setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))
								.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
						.uri("lb://AUTHSERVER"))
				
				
				.route(p -> p.path("/shopping/product/**")
						.filters(f -> f.rewritePath("/shopping/product/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
								.retry(retryConfig -> retryConfig.setRetries(3)
										.setMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
										.setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))
								.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
						.uri("lb://PRODUCTSERVICE"))

//				.route(p -> p.path("/shopping/auth/**")
//						.filters(f -> f.rewritePath("/shopping/auth/(?<segment>.*)", "/${segment}")
//								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
////								.addResponseHeader("Access-Control-Allow-Origin", "http://localhost:5173")
////								.addResponseHeader("Access-Control-Allow-Headers", "*")
////								.addResponseHeader("Access-Control-Allow-Methods", "*")
////								.addResponseHeader("Access-Control-Allow-Credentials", "true")
////								.dedupeResponseHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS,
////									DedupeResponseHeaderGatewayFilterFactory.Strategy.RETAIN_UNIQUE.name())
////								.dedupeResponseHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
////										DedupeResponseHeaderGatewayFilterFactory.Strategy.RETAIN_UNIQUE.name())
//								.retry(retryConfig -> retryConfig.setRetries(3)
//										.setMethods(HttpMethod.GET, HttpMethod.POST, HttpMethod.OPTIONS)
//										.setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000), 2, true))
//								.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
//						.uri("lb://AUTHSERVER"))
				
//				.route(p -> p.path("/eazybank/cards/**").filters(f -> f
//						.rewritePath("/eazybank/cards/(?<segment>.*)", "/${segment}")
//						.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()).requestRateLimiter(
//								config -> config.setRateLimiter(redisRateLimiter()).setKeyResolver(userKeyResolver())))
//						.uri("lb://CARDS"))
				.build();
	}

	@Bean
	public Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer() {
		return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
				.circuitBreakerConfig(CircuitBreakerConfig.ofDefaults())
				.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(10)).build()).build());
	}

	@Bean
	public RedisRateLimiter redisRateLimiter() {
		return new RedisRateLimiter(1, 1, 1);
	}

	@Bean
	KeyResolver userKeyResolver() {
		return exchange -> Mono.justOrEmpty(exchange.getRequest().getHeaders().getFirst("user"))
				.defaultIfEmpty("anonymous");
	}
}
