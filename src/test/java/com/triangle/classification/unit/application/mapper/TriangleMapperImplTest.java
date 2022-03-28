package com.triangle.classification.unit.application.mapper;

import com.triangle.classification.application.mapper.triangle.TriangleMapperImpl;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class TriangleMapperImplTest {

    @InjectMocks
    private TriangleMapperImpl triangleMapper;

    @Test
    public void should_mapper_from_triangle_entity_to_domain() {
        Triangle expectedTriangle = new Triangle(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE);
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE);
        final Triangle triangle = triangleMapper.fromTriangleEntrypointRequestToTriangleDomain(request);
        Assertions.assertThat(triangle).usingRecursiveComparison()
                .isEqualTo(expectedTriangle);
    }

    @Test
    public void should_mapper_from_triangle_domain_to_entity() {
        TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.EQUILATERAL.getType());
        final TriangleEntrypointResponse response = triangleMapper.fromTriangleDomainToTriangleEntrypointResponse(TriangleType.EQUILATERAL);
        Assertions.assertThat(response).isEqualTo(expected);
    }
}
