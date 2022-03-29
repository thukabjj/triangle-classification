package com.triangle.classification.usecase.authentication;

import com.triangle.classification.usecase.authentication.entity.JwtResponse;
import com.triangle.classification.usecase.authentication.exception.InvalidCredentialsException;


public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    private final AuthenticateService authenticateService;


    public AuthenticationUseCaseImpl(AuthenticateService authenticateService) {
        this.authenticateService = authenticateService;
    }

    public JwtResponse execute(final String username, final String password) {

        final boolean isAuthenticated = authenticateService.isAuthenticated(username, password);

        if (isAuthenticated) {
            return authenticateService.authenticate(username, password);

        }

        throw new InvalidCredentialsException("Invalid Credentials");


    }
}
