package com.triangle.classification.application.mapper.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.usecase.authentication.entity.JwtResponse;

public interface AuthenticationMapper {
    AuthenticationEntrypointResponse fromDomainToResponse(JwtResponse response);
}
