package com.triangle.classification.application.mapper.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;

public interface AuthenticationMapper {
    AuthenticationEntrypointResponse fromDomainToResponse(JwtResponse response);
}
