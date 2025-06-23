package com.example.hotelmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // permite accesul la orice URL
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/hotels", true) // redirecționează după login
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }
}
