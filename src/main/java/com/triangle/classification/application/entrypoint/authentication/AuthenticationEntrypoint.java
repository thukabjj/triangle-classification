package com.triangle.classification.application.entrypoint.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.application.mapper.authentication.AuthenticationMapper;
import com.triangle.classification.usecase.authentication.AuthenticationUseCase;
import com.triangle.classification.usecase.authentication.entity.JwtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationEntrypoint {
    private final AuthenticationUseCase authenticationUseCase;
    private final AuthenticationMapper authenticationMapper;

    public AuthenticationEntrypoint(AuthenticationUseCase authenticationUseCase, AuthenticationMapper authenticationMapper) {
        this.authenticationUseCase = authenticationUseCase;
        this.authenticationMapper = authenticationMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationEntrypointResponse> loginUser(@RequestHeader("user_name") String username,
                                       @RequestHeader("password") String password) {

        final JwtResponse jwtResponse = authenticationUseCase.execute(username, password);
        final AuthenticationEntrypointResponse response = authenticationMapper.fromDomainToResponse(jwtResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
