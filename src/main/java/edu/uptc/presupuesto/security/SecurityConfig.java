package edu.uptc.presupuesto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/rubros/**").permitAll() // Permitir acceso sin autenticación a estas rutas
                        .anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
                )
                .formLogin(form -> form.disable()) // Deshabilitar el formulario de login por defecto
                .httpBasic(Customizer.withDefaults()); // Habilitar autenticación básica HTTP
        return http.build();
    }
}