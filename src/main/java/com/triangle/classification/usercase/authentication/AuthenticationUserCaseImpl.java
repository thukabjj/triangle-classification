package com.triangle.classification.usercase.authentication;

import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import com.triangle.classification.usercase.authentication.exception.InvalidCredentialsException;


public class AuthenticationUserCaseImpl implements AuthenticationUserCase {

    private final AuthenticateService authenticateService;


    public AuthenticationUserCaseImpl(AuthenticateService authenticateService) {
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
