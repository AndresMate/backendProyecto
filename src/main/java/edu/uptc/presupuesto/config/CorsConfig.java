package edu.uptc.presupuesto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://158.247.122.111:3000"); // Origen del frontend en la nube
        config.addAllowedOrigin("http://localhost:3000"); // Origen del frontend local
        config.addAllowedOrigin("https://backendproyecto-1l2x.onrender.com"); // Origen del frontend local

        config.addAllowedMethod("*"); // Permitir todos los métodos HTTP (GET, POST, etc.)
        config.addAllowedHeader("*"); // Permitir todos los encabezados
        config.setAllowCredentials(true); // Permitir envío de cookies o credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Aplicar la configuración a todas las rutas
        return new CorsFilter(source);
    }
}
