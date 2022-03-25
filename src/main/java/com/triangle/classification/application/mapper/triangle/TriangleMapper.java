package com.triangle.classification.application.mapper.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

import java.util.List;

public interface TriangleMapper {
    Triangle toTriangleDomain(TriangleEntrypointRequest request);

    TriangleEntrypointResponse fromTriangleDomainToResponse(TriangleType triangleType);

    TriangleEntity fromTriangleDomainToTriangleDAO(Triangle triangle);

    Triangle fromTriangleDAOToTriangleDomain(TriangleEntity trianglesDAO);

    List<Triangle> fromTrianglesDAOToTrianglesDomain(Iterable<TriangleEntity> trianglesDAO);
}
