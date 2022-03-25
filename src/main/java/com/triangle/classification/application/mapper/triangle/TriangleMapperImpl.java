package com.triangle.classification.application.mapper.triangle;

import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public class TriangleMapperImpl implements TriangleMapper {

    @Override
    public Triangle toTriangleDomain(TriangleEntrypointRequest request) {
        final Triangle triangle = new Triangle(request.sideA(),request.sideB(),request.sideC());
        return triangle;
    }

    @Override
    public TriangleEntrypointResponse fromTriangleDomainToResponse(TriangleType triangleType) {
        return new TriangleEntrypointResponse(triangleType.getType());
    }
}
