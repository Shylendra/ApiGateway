package com.smartapps.apigateway.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableDiscoveryClient
public class RoutesConfig {

	/* This is required as application.yml config not working */
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	    return builder.routes()
	      .route("SmartUser", r -> r
	    		.path("/smartuser-api/**")
	    		.uri("lb://SmartUser"))
	      .route("SmartAddress", r -> r
	  	        .path("/smartaddress-api/**")
	  	        .uri("lb://SmartAddress"))
	      .route("SmartProfile", r -> r
	  	        .path("/smartprofile-api/**")
	  	        .uri("lb://SmartProfile"))
	    .build();
	}
	
	/* This is required for Loadbalancer(lb:) to work */
    @Bean
    WebClient client() {
        return WebClient.builder()
            .build();
    }
}
