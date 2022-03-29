package com.triangle.classification.application.mapper.authentication;

import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import com.triangle.classification.usecase.authentication.entity.JwtResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthenticationMapperImplTest {

    @InjectMocks
    private AuthenticationMapperImpl authenticationMapper;

    @Test
    public void should_mapper_from_jwt_response_entrypoint_to_authentication_entrypoint() {

        final AuthenticationEntrypointResponse expected = new AuthenticationEntrypointResponse("triangle",
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODQyMDY3MCwiZXhwIjoxNjQ4NDIwOTcwfQ.MCrhu6OyN1W5a6W8pI7XvIFK5WdtOkvaIK0OQ_f4N_Q",
                "Bearer",
                1648420970000L);

        JwtResponse jwtResponse = new JwtResponse("triangle",
                "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0cmlhbmdsZSIsImlhdCI6MTY0ODQyMDY3MCwiZXhwIjoxNjQ4NDIwOTcwfQ.MCrhu6OyN1W5a6W8pI7XvIFK5WdtOkvaIK0OQ_f4N_Q",
                "Bearer",
                1648420970000L);

        final AuthenticationEntrypointResponse response = authenticationMapper.fromDomainToResponse(jwtResponse);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);

    }

}
