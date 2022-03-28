package com.triangle.classification.infrastructure.spring;

import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.mapper.triangle.TriangleMapperImpl;
import com.triangle.classification.usercase.authentication.AuthenticateService;
import com.triangle.classification.usercase.authentication.AuthenticationUserCaseImpl;
import com.triangle.classification.usercase.gateway.repository.TriangleRepository;
import com.triangle.classification.usercase.triangle.classifier.TriangleTypeClassifierUserCase;
import com.triangle.classification.usercase.triangle.classifier.TriangleTypeClassifierUserCaseImpl;
import com.triangle.classification.usercase.triangle.history.TriangleHistoryUserCase;
import com.triangle.classification.usercase.triangle.history.TriangleHistoryUserCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TriangleMapper injectTriangleMapper() {
        return new TriangleMapperImpl();
    }

    @Bean
    public TriangleTypeClassifierUserCase injectTriangleCalculateType (TriangleRepository triangleRepository) {
        return new TriangleTypeClassifierUserCaseImpl(triangleRepository);
    }

    @Bean
    public TriangleHistoryUserCase injectTriangleHistory(TriangleRepository triangleRepository){
        return new TriangleHistoryUserCaseImpl(triangleRepository);
    }

    @Bean
    public AuthenticationUserCaseImpl injectAuthenticationUserCase(AuthenticateService authenticateService) {return new AuthenticationUserCaseImpl(authenticateService); }
}
