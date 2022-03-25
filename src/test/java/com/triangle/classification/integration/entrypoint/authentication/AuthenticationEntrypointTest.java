package com.triangle.classification.integration.entrypoint.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.triangle.classification.application.entrypoint.authentication.entity.AuthenticationEntrypointResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticationEntrypointTest {

    @Autowired
    private MockMvc mockMvc;



    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void should_return_jwt_token_with_http_status_code_created() throws Exception {


        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/auth/login?user_name=triangle&password=classification")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        final AuthenticationEntrypointResponse response = OBJECT_MAPPER.readValue(result.getResponse().getContentAsString(), AuthenticationEntrypointResponse.class);

        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(response.token()).isNotEmpty();
        Assertions.assertThat(response.type()).isNotEmpty();
        Assertions.assertThat(response.username()).isNotEmpty();
        Assertions.assertThat(response.expirationTime()).isNotNull();
    }
}
