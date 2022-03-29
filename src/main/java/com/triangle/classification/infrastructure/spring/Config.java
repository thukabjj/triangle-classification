package com.triangle.classification.infrastructure.spring;

import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.mapper.triangle.TriangleMapperImpl;
import com.triangle.classification.usecase.authentication.AuthenticateService;
import com.triangle.classification.usecase.authentication.AuthenticationUseCaseImpl;
import com.triangle.classification.usecase.gateway.repository.TriangleRepository;
import com.triangle.classification.usecase.triangle.classifier.TriangleTypeClassifierUseCase;
import com.triangle.classification.usecase.triangle.classifier.TriangleTypeClassifierUseCaseImpl;
import com.triangle.classification.usecase.triangle.history.TriangleHistoryUseCase;
import com.triangle.classification.usecase.triangle.history.TriangleHistoryUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TriangleMapper injectTriangleMapper() {
        return new TriangleMapperImpl();
    }

    @Bean
    public TriangleTypeClassifierUseCase injectTriangleCalculateType (TriangleRepository triangleRepository) {
        return new TriangleTypeClassifierUseCaseImpl(triangleRepository);
    }

    @Bean
    public TriangleHistoryUseCase injectTriangleHistory(TriangleRepository triangleRepository){
        return new TriangleHistoryUseCaseImpl(triangleRepository);
    }

    @Bean
    public AuthenticationUseCaseImpl injectAuthenticationUserCase(AuthenticateService authenticateService) {return new AuthenticationUseCaseImpl(authenticateService); }
}
