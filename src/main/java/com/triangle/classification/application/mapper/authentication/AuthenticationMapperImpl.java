package com.triangle.classification.application.mapper.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMapperImpl implements AuthenticationMapper {

    @Override
    public AuthenticationEntrypointResponse fromDomainToResponse(JwtResponse response) {
        return new AuthenticationEntrypointResponse(response.username(), response.token(), response.type(), response.expirationTime());
    }
}
