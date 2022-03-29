package com.triangle.classification.usecase.authentication;

import com.triangle.classification.usecase.authentication.entity.JwtResponse;
import com.triangle.classification.usecase.authentication.exception.InvalidCredentialsException;
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
public class AuthenticationUseCaseImplTest {

    @InjectMocks
    private AuthenticationUseCaseImpl authenticationUseCase;

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
        final JwtResponse response = authenticationUseCase.execute("test", "test");

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_returning_authenticate_exception(){

        //When
        when(authenticateService.isAuthenticated(anyString(),anyString())).thenReturn(Boolean.FALSE);

        //Then
        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authenticationUseCase.execute("test", "test");
        });

        assertEquals("Invalid Credentials", exception.getMessage());
    }


}
