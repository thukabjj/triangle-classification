package com.triangle.classification.application.entrypoint.authentication;

import com.triangle.classification.usercase.authentication.AuthenticationUserCase;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationEntrypoint {
    private final AuthenticationUserCase authenticationUserCase;

    public AuthenticationEntrypoint(AuthenticationUserCase authenticationUserCase) {
        this.authenticationUserCase = authenticationUserCase;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> loginUser(@RequestParam("user_name") String username,
                                       @RequestParam("password") String password) {

        final JwtResponse response = authenticationUserCase.execute(username, password);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
