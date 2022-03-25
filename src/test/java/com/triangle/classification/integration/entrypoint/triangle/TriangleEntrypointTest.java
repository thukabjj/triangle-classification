package com.triangle.classification.integration.entrypoint.triangle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.TriangleType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class TriangleEntrypointTest {

    @Autowired
    private MockMvc mockMvc;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Test
    public void should_returning_triangle_type_with_http_status_code_created_with_triangle_type_equilateral() throws Exception{
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE);
        String postValue = OBJECT_MAPPER.writeValueAsString(request);

        MvcResult triangleResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/triangle/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postValue))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        final TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.EQUILATERAL.getType());
        final TriangleEntrypointResponse response = OBJECT_MAPPER.readValue(triangleResult.getResponse().getContentAsString(), TriangleEntrypointResponse.class);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }


    @Test
    public void should_returning_triangle_type_with_http_status_code_created_with_triangle_type_isosceles() throws Exception{
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.TEN);
        String postValue = OBJECT_MAPPER.writeValueAsString(request);

        MvcResult triangleResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/triangle/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postValue))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        final TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.ISOSCELES.getType());
        final TriangleEntrypointResponse response = OBJECT_MAPPER.readValue(triangleResult.getResponse().getContentAsString(), TriangleEntrypointResponse.class);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }


    @Test
    public void should_returning_triangle_type_with_http_status_code_created_with_triangle_type_scalene() throws Exception{
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE,BigDecimal.TEN,BigDecimal.ZERO);
        String postValue = OBJECT_MAPPER.writeValueAsString(request);

        MvcResult triangleResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/triangle/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postValue))
                .andExpect(status().isCreated())
                .andDo(print())
                .andReturn();

        final TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.SCALENE.getType());
        final TriangleEntrypointResponse response = OBJECT_MAPPER.readValue(triangleResult.getResponse().getContentAsString(), TriangleEntrypointResponse.class);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }
}