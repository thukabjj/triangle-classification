package com.triangle.classification.usercase.authentication;

import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import com.triangle.classification.usercase.authentication.exception.InvalidCredentialsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class AuthenticationUserCaseImpl implements AuthenticationUserCase {

    protected final Log logger = LogFactory.getLog(getClass());
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
