package com.turistrazo.turistrazo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        JWTAuthorizationFilter jwtAuthorizationFilter = new JWTAuthorizationFilter();

        return http.cors().and()
                .csrf().ignoringRequestMatchers(new AntPathRequestMatcher("/login"))
                .disable()
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/api/users/register")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/users/user-type")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/users/verify/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/tour/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/neighborhood/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/resenas")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/login")).permitAll())
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
