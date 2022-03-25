package com.triangle.classification.usercase.authentication;

import com.triangle.classification.usercase.authentication.entity.JwtResponse;

public interface AuthenticationUserCase {
    JwtResponse execute(final String username, final String password);
}
