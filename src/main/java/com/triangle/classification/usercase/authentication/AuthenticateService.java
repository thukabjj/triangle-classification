package com.triangle.classification.usercase.authentication;

import com.triangle.classification.usercase.authentication.entity.JwtResponse;

public interface AuthenticateService {

    boolean isAuthenticated (final String username, final String password);

    JwtResponse authenticate(final String username, final String password);

}
