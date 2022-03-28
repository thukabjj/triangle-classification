package com.triangle.classification.unit.application.entrypoint.authentication;

import com.triangle.classification.application.entrypoint.authentication.AuthenticationEntrypoint;
import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.application.mapper.authentication.AuthenticationMapper;
import com.triangle.classification.usercase.authentication.AuthenticationUserCase;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationEntrypointTest {

    @InjectMocks
    private AuthenticationEntrypoint entrypoint;

    @Mock
    private AuthenticationUserCase authenticationUserCase;

    @Mock
    private AuthenticationMapper authenticationMapper;

    @Test
    public void should_authenticate_with_successful(){

        //Given
        JwtResponse jwtResponse = new JwtResponse("triangle",
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODQyMDY3MCwiZXhwIjoxNjQ4NDIwOTcwfQ.MCrhu6OyN1W5a6W8pI7XvIFK5WdtOkvaIK0OQ_f4N_Q",
                "Bearer",
                1648420970000L);
        AuthenticationEntrypointResponse expected = new AuthenticationEntrypointResponse("triangle",
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODQyMDY3MCwiZXhwIjoxNjQ4NDIwOTcwfQ.MCrhu6OyN1W5a6W8pI7XvIFK5WdtOkvaIK0OQ_f4N_Q",
                "Bearer",
                1648420970000L);
        //When
        when(authenticationUserCase.execute(anyString(),anyString())).thenReturn(jwtResponse);
        when(authenticationMapper.fromDomainToResponse(any(JwtResponse.class))).thenReturn(expected);

        //Then
        ResponseEntity<AuthenticationEntrypointResponse> response = entrypoint.loginUser("test", "test");

    }

}
