package com.triangle.classification.application.entrypoint.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.application.mapper.authentication.AuthenticationMapper;
import com.triangle.classification.usercase.authentication.AuthenticationUserCase;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationEntrypoint {
    private final AuthenticationUserCase authenticationUserCase;
    private final AuthenticationMapper authenticationMapper;

    public AuthenticationEntrypoint(AuthenticationUserCase authenticationUserCase, AuthenticationMapper authenticationMapper) {
        this.authenticationUserCase = authenticationUserCase;
        this.authenticationMapper = authenticationMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationEntrypointResponse> loginUser(@RequestHeader("user_name") String username,
                                       @RequestHeader("password") String password) {

        final JwtResponse jwtResponse = authenticationUserCase.execute(username, password);
        final AuthenticationEntrypointResponse response = authenticationMapper.fromDomainToResponse(jwtResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
