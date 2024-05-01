package com.dragon.dungeon.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dragon.dungeon.services.security.filter.JwtFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

        private final JwtFilter jwtFilter;
        @Bean
        public DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
                return http
                        // Отключение аутентификации по HTTP
                        .httpBasic(AbstractHttpConfigurer::disable)
                        // Отключение проверки CSRF токена
                        .csrf(AbstractHttpConfigurer::disable)
                        // Ставим политику сессий на STATELESS - отключаем хранение сессий
                        .sessionManagement(config -> config.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                        // Настраиваем доступ к end-points
                        .authorizeHttpRequests(config ->
                                config.
                                        requestMatchers(HttpMethod.POST, "/v1/auth/**").permitAll()
                                        .requestMatchers(HttpMethod.POST, "/v1/auth/register").permitAll()
                                        // .requestMatchers("/swagger-ui/**").permitAll()
                                        // .requestMatchers("/v3/api-docs/**").permitAll()
                                        .requestMatchers("/static/**").permitAll()
                                        .anyRequest().authenticated()
                        )
                        //requestMatchers("/v1/collection").authenticated()
                        // Отключаем логин через форму
                        .formLogin(AbstractHttpConfigurer::disable)
                        // Добавляем JWT Filter перед фильтром аутентификации по Username/Password
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                        // Инициализируем полученный объект политик и возвращаем из метода
                        .build();
        }
}
