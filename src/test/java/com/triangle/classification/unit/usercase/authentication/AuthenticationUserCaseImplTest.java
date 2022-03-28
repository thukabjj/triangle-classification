package com.triangle.classification.unit.usercase.authentication;

import com.triangle.classification.usercase.authentication.AuthenticateService;
import com.triangle.classification.usercase.authentication.AuthenticationUserCaseImpl;
import com.triangle.classification.usercase.authentication.entity.JwtResponse;
import com.triangle.classification.usercase.authentication.exception.InvalidCredentialsException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthenticationUserCaseImplTest {

    @InjectMocks
    private AuthenticationUserCaseImpl authenticationUserCase;

    @Mock
    private AuthenticateService authenticateService;

    @Test
    public void should_authenticate_with_successful(){

        //Given
        JwtResponse expected = new JwtResponse("triangle",
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODQyMDY3MCwiZXhwIjoxNjQ4NDIwOTcwfQ.MCrhu6OyN1W5a6W8pI7XvIFK5WdtOkvaIK0OQ_f4N_Q",
                "Bearer",
                1648420970000L);

        //When
        when(authenticateService.isAuthenticated(anyString(),anyString())).thenReturn(Boolean.TRUE);
        when(authenticateService.authenticate(anyString(),anyString())).thenReturn(expected);

        //Then
        final JwtResponse response = authenticationUserCase.execute("test", "test");

        Assertions.assertThat(response).isEqualTo(expected);
    }

    @Test
    public void should_returning_authenticate_exception(){

        //When
        when(authenticateService.isAuthenticated(anyString(),anyString())).thenReturn(Boolean.FALSE);

        //Then
        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authenticationUserCase.execute("test", "test");
        });

        assertEquals("Invalid Credentials", exception.getMessage());
    }


}
