package com.example.travelpal.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final String crossOrigin;

    public WebConfig(@Value("${cross.origin}") String crossOrigin) {
        this.crossOrigin = crossOrigin;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if ("*".equals(crossOrigin)) {
            // When allowing all origins, set allowCredentials to false for security
            registry.addMapping("/**")
                    .allowedOrigins("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(false);
        } else {
            registry.addMapping("/**")
                    .allowedOrigins(crossOrigin)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedHeaders("*")
                    .allowCredentials(true);
        }
    }
}

