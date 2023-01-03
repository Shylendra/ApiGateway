package com.smartapps.apigateway.config;

//@Configuration
public class GatewayCorsConfiguration extends org.springframework.web.cors.CorsConfiguration {
    
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//      CorsConfiguration apiCorsConfiguration = new CorsConfiguration();
//      apiCorsConfiguration.setAllowCredentials(true);
//      apiCorsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//      apiCorsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
//      apiCorsConfiguration.setAllowedMethods(Collections.singletonList("*"));
//
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", apiCorsConfiguration);
//      return source;
//    }
    
//    @Bean
//    public CorsWebFilter corsFilter() {
//      org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
//      corsConfiguration.setAllowCredentials(true);
//      //corsConfiguration.addAllowedOrigin("*");
//      corsConfiguration.setAllowedOriginPatterns(Collections.singletonList("*"));
//      corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
//      corsConfiguration.addAllowedHeader("origin");
//      corsConfiguration.addAllowedHeader("content-type");
//      corsConfiguration.addAllowedHeader("accept");
//      corsConfiguration.addAllowedHeader("authorization");
//      corsConfiguration.addAllowedHeader("cookie");
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", corsConfiguration);
//      return new CorsWebFilter(source);
//    }
    
}
