package com.triangle.classification.infrastructure.jwt;

import com.triangle.classification.usercase.authentication.AuthenticateService;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import com.triangle.classification.usercase.authentication.entity.JwtType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsServiceImpl userDetailsService;
    private final JwtTokenUtil jwtTokenUtilImpl;

    public AuthenticateServiceImpl(AuthenticationManager authenticationManager, JwtUserDetailsServiceImpl userDetailsService, JwtTokenUtil jwtTokenUtilImpl) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtilImpl = jwtTokenUtilImpl;
    }

    @Override
    public boolean isAuthenticated(String username, String password) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        return auth.isAuthenticated();
    }

    @Override
    public JwtResponse authenticate(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        String token = jwtTokenUtilImpl.generateToken(userDetails);
        final Date expirationDateFromToken = jwtTokenUtilImpl.getExpirationDateFromToken(token);
        return new JwtResponse(username, token, JwtType.Bearer.getType(), expirationDateFromToken.getTime());
    }
}
