package com.triangle.classification.usercase.triangle.history;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.usercase.gateway.repository.TriangleRepository;

import java.util.List;

public class TriangleHistoryUserCaseImpl implements TriangleHistoryUserCase {

    private final TriangleRepository triangleRepository;

    public TriangleHistoryUserCaseImpl(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }

    @Override
    public List<Triangle> execute() {
        return triangleRepository.getAllTriangles();
    }
}
