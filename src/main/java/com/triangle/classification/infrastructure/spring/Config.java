package com.triangle.classification.infrastructure.spring;

import com.triangle.classification.application.entrypoint.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.entrypoint.mapper.triangle.TriangleMapperImpl;
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
}
