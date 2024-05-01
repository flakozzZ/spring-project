package com.flakozzz.eCommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;


@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("*")); // Разрешить все источники
        corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Разрешить все методы
        corsConfiguration.setAllowedHeaders(List.of("*")); // Разрешить все заголовки
        corsConfiguration.setAllowCredentials(true); // Разрешить куки и аутентификацию с клиента
        corsConfiguration.setMaxAge(3600L); // Кэширование CORS конфигурации на 1 час

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // Применить конфигурацию для всех URL-адресов

        return new CorsFilter(source);
    }
}
