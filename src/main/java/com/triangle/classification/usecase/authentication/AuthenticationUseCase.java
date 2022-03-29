package com.triangle.classification.usecase.authentication;

import com.triangle.classification.usecase.authentication.entity.JwtResponse;

public interface AuthenticationUseCase {
    JwtResponse execute(final String username, final String password);
}
