package com.example.agrismart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable()) // disable CSRF for dev/API
      .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // allow H2 iframe
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/h2-console/**").permitAll()   // allow H2 console
        .requestMatchers("/auth/**").permitAll()        // public auth endpoints
        .requestMatchers("/index.html", "/js/**", "/css/**").permitAll() // static resources
        .anyRequest().authenticated()                   // all others require auth
      );

    return http.build();
  }
}
