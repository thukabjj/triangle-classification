package com.triangle.classification.infrastructure.spring;

import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.mapper.triangle.TriangleMapperImpl;
import com.triangle.classification.usercase.authentication.AuthenticateService;
import com.triangle.classification.usercase.authentication.AuthenticationUserCaseImpl;
import com.triangle.classification.usercase.triangle.TriangleCalculateType;
import com.triangle.classification.usercase.triangle.TriangleCalculateTypeUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TriangleMapper injectTriangleMapper() {
        return new TriangleMapperImpl();
    }

    @Bean
    public TriangleCalculateType injectTriangleCalculateType () {return new TriangleCalculateTypeUserCase();}

    @Bean
    public AuthenticationUserCaseImpl injectAuthenticationUserCase(AuthenticateService authenticateService) {return new AuthenticationUserCaseImpl(authenticateService); }
}
