package com.triangle.classification.application.entrypoint.mapper.triangle;

import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public class TriangleMapperImpl implements TriangleMapper {

    @Override
    public Triangle toTriangleDomain(TriangleEntrypointRequest request) {
        final Triangle triangle = new Triangle();
        triangle.setSideA(request.sideA());
        triangle.setSideB(request.sideB());
        triangle.setSideC(request.sideC());
        return triangle;
    }

    @Override
    public TriangleEntrypointResponse fromTriangleDomainToResponse(TriangleType triangleType) {
        return new TriangleEntrypointResponse(triangleType.getType());
    }
}
