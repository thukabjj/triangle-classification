package com.triangle.classification.application.mapper.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleHistoryEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TriangleMapperImplTest {

    @InjectMocks
    private TriangleMapperImpl triangleMapper;

    @Test
    public void should_mapper_from_triangle_entity_to_domain() {
        Triangle expectedTriangle = new Triangle(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
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

    @Test
    public void should_mapper_from_triangle_domain_to_triangle_dao() {

        Triangle triangle = new Triangle(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        final TriangleEntity expected = new TriangleEntity(String.valueOf(triangle.getSideA()), String.valueOf(triangle.getSideB()), String.valueOf(triangle.getSideC()), triangle.getType().getType());


        final TriangleEntity response = triangleMapper.fromTriangleDomainToTriangleDAO(triangle);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_mapper_from_triangle_dao_to_triangle_domain() {

        Triangle expected = new Triangle(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE);
        TriangleEntity triangleEntity = new TriangleEntity(String.valueOf(expected.getSideA()), String.valueOf(expected.getSideB()), String.valueOf(expected.getSideC()), expected.getType().getType());

        final Triangle response = triangleMapper.fromTriangleDAOToTriangleDomain(triangleEntity);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_mapper_from_triangles_dao_to_triangles_domain() {

        final List<TriangleHistoryEntrypointResponse> expected = List.of(
                new TriangleHistoryEntrypointResponse("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, TriangleType.ISOSCELES.getType()),
                new TriangleHistoryEntrypointResponse("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, TriangleType.EQUILATERAL.getType()),
                new TriangleHistoryEntrypointResponse("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, TriangleType.SCALENE.getType())
        );

        final List<Triangle> triangles = List.of(
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, TriangleType.ISOSCELES),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, TriangleType.EQUILATERAL),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, TriangleType.SCALENE));

        final List<TriangleHistoryEntrypointResponse> response = triangleMapper.fromTrianglesToTriangleHistoryEntrypointResponse(triangles);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_mapper_from_triangles_domain_to_triangles_history_entrypoint_response() {

        final List<Triangle> expected = List.of(
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, TriangleType.EQUILATERAL),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, TriangleType.ISOSCELES),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ONE, TriangleType.SCALENE));


        final List<TriangleEntity> triangleEntities = List.of(
                new TriangleEntity("642403e1-f980-4a14-9729-e8b4487ea522", String.valueOf(BigDecimal.ONE), String.valueOf(BigDecimal.ONE), String.valueOf(BigDecimal.ONE), TriangleType.EQUILATERAL.getType()),
                new TriangleEntity("642403e1-f980-4a14-9729-e8b4487ea522", String.valueOf(BigDecimal.ONE), String.valueOf(BigDecimal.TEN), String.valueOf(BigDecimal.ONE), TriangleType.ISOSCELES.getType()),
                new TriangleEntity("642403e1-f980-4a14-9729-e8b4487ea522", String.valueOf(BigDecimal.TEN), String.valueOf(BigDecimal.ZERO), String.valueOf(BigDecimal.ONE), TriangleType.SCALENE.getType())
        );


        final List<Triangle> response = triangleMapper.fromTrianglesDAOToTrianglesDomain(triangleEntities);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_mapper_from_triangles_domain_to_triangles_history_entrypoint_response_empty() {

        final List<Triangle> expected = new ArrayList<>();

        final List<TriangleEntity> triangleEntities = new ArrayList<>();


        final List<Triangle> response = triangleMapper.fromTrianglesDAOToTrianglesDomain(triangleEntities);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    public void should_mapper_from_triangles_domain_to_triangles_history_entrypoint_response_null() {

        final List<Triangle> expected = new ArrayList<>();


        final List<Triangle> response = triangleMapper.fromTrianglesDAOToTrianglesDomain(null);

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }


}
