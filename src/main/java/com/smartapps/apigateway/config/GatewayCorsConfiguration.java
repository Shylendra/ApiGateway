package com.smartapps.apigateway.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class GatewayCorsConfiguration {
    
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration apiCorsConfiguration = new CorsConfiguration();
      apiCorsConfiguration.setAllowCredentials(true);
      apiCorsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
      apiCorsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
      apiCorsConfiguration.setAllowedMethods(Collections.singletonList("*"));

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", apiCorsConfiguration);
      return source;
    }
}
