package com.img.OAuth2Demo.config;

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
    public SecurityFilterChain securityFilterChain(HttpSecurity htt) throws Exception {
        return htt.csrf(csrf->csrf.disable())
                .cors().and()
                .authorizeHttpRequests().requestMatchers("/redirect","hi").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/**").authenticated()
                .and()
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
