package com.taxi.user.config;

import com.taxi.user.controller.AuthControllerImplement;
import com.taxi.user.service.AuthService;
import com.taxi.user.service.ExtendedAuthServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    public AuthControllerImplement authControllerImplement(ExtendedAuthServiceImpl extendedAuthService) {
//        return AuthControllerImplement.builder()
//                .extendedAuthService(extendedAuthService)
//                .build();
//    }
}
