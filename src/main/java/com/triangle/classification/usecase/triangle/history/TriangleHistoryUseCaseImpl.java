package com.triangle.classification.usecase.triangle.history;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.usecase.gateway.repository.TriangleRepository;

import java.util.List;

public class TriangleHistoryUseCaseImpl implements TriangleHistoryUseCase {

    private final TriangleRepository triangleRepository;

    public TriangleHistoryUseCaseImpl(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }

    @Override
    public List<Triangle> execute() {
        return triangleRepository.getAllTriangles();
    }
}
