package com.triangle.classification.integration.usercase.authentication;

import com.triangle.classification.usercase.authentication.AuthenticateService;
import com.triangle.classification.usercase.authentication.AuthenticationUserCaseImpl;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import com.triangle.classification.usercase.exception.InvalidCredentialsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationUserCaseImplTest {

    @InjectMocks
    private AuthenticationUserCaseImpl authenticationUserCase;

    @Mock
    private AuthenticateService authenticateService;

    @Test
    public void should_returning_token_with_successful() {

        //Given
        String userName = "triangle";
        String password = "classification";
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODE3MDA3NiwiZXhwIjoxNjQ4MTcwMzc2fQ.q2sAi0afCHBZgFaWmYgotXLS073ZzGgiefCcOnuv_jg";
        JwtResponse mockedJwtResponse = new JwtResponse(userName, token, "Bearer", 1648170376000l);
        //When
        when(authenticateService.isAuthenticated(anyString(), anyString())).thenReturn(true);
        when(authenticateService.authenticate(anyString(), anyString())).thenReturn(mockedJwtResponse);

        //Then
        final JwtResponse response = authenticationUserCase.execute(userName, password);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(mockedJwtResponse);

    }

    @Test
    public void should_returning_invalid_credentials_exception() {

        //Given
        String userName = "triangle";
        String password = "classification";

        //When
        when(authenticateService.isAuthenticated(anyString(), anyString())).thenReturn(false);


        //Then
        InvalidCredentialsException thrown = assertThrows(InvalidCredentialsException.class,
                ()->{
                    authenticationUserCase.execute(userName, password);
                });

        assertTrue(thrown.getMessage().contains("Invalid Credentials"));
    }

}
