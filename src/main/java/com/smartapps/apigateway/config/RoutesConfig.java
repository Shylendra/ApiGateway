package com.smartapps.apigateway.config;

import java.util.function.Function;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableDiscoveryClient
public class RoutesConfig {

	/* https://stackoverflow.com/questions/74398260/request-from-angular-to-spring-gateway-fails-cors-error */
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder, Function<GatewayFilterSpec, UriSpec> brutalCorsFilters) {
	    return builder.routes()
	      .route("SmartUser", r -> r
	    		.path("/smartuser-api/**")
	    		.filters(brutalCorsFilters)
	    		.uri("lb://SmartUser"))
	      .route("SmartAddress", r -> r
	  	        .path("/smartaddress-api/**")
	  	        .filters(brutalCorsFilters)
	  	        .uri("lb://SmartAddress"))
	      .route("SmartReferenceData", r -> r
		  	        .path("/smartreferencedata-api/**")
		  	        .filters(brutalCorsFilters)
		  	        .uri("lb://SmartReferenceData"))
	      .route("SmartJourney", r -> r
		  	        .path("/smartjourney-api/**")
		  	        .filters(brutalCorsFilters)
		  	        .uri("lb://SmartJourney"))
	      .route("SmartProfile", r -> r
		  	        .path("/smartprofile-api/**")
		  	        .filters(brutalCorsFilters)
		  	        .uri("lb://SmartProfile"))
	    .build();
	}
	
	@Bean
	Function<GatewayFilterSpec, UriSpec> brutalCorsFilters() {
	    return f -> f
	            .setResponseHeader("Access-Control-Allow-Origin", "*")
	            .setResponseHeader("Access-Control-Allow-Methods", "*")
	            .setResponseHeader("Access-Control-Expose-Headers", "*");
	}
	
//	/* This is required as application.yml config not working */
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	      .route("SmartUser", r -> r
//	    		.path("/smartuser-api/**")
//	    		.uri("lb://SmartUser"))
//	      .route("SmartAddress", r -> r
//	  	        .path("/smartaddress-api/**")
//	  	        .uri("lb://SmartAddress"))
//	      .route("SmartProfile", r -> r
//	  	        .path("/smartprofile-api/**")
//	  	        .uri("lb://SmartProfile"))
//	    .build();
//	}
	
	/* This is required for Loadbalancer(lb:) to work */
    @Bean
    WebClient client() {
        return WebClient.builder()
            .build();
    }
}
