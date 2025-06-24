package com.cd.Arcadius;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //
        // http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
        // auth -> auth.requestMatchers("/api/v1/auth/register",
        // "/api/v1/auth/login").permitAll().anyRequest()
        // .authenticated())
        // .httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable()) // désactive la protection CSRF pour les appels API REST
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // autorise toutes les requêtes
                );

        return http.build();
    }
}
