package com.triangle.classification.usecase.gateway.repository;

import com.triangle.classification.domain.triangle.Triangle;

import java.util.List;

public interface TriangleRepository {
    Triangle save(Triangle triangle);
    List<Triangle> getAllTriangles();
}
