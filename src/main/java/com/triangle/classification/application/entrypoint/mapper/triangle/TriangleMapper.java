package com.triangle.classification.application.entrypoint.mapper.triangle;

import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public interface TriangleMapper {
    Triangle toTriangleDomain(TriangleEntrypointRequest request);
    TriangleEntrypointResponse fromTriangleDomainToResponse(TriangleType triangleType);
}
