package com.triangle.classification.usecase.authentication;

import com.triangle.classification.usecase.authentication.entity.JwtResponse;

public interface AuthenticateService {

    boolean isAuthenticated (final String username, final String password);

    JwtResponse authenticate(final String username, final String password);

}
