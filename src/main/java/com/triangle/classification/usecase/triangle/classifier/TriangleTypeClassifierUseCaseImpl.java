package com.triangle.classification.usecase.triangle.classifier;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usecase.gateway.repository.TriangleRepository;

public class TriangleTypeClassifierUseCaseImpl implements TriangleTypeClassifierUseCase {

    private final TriangleRepository triangleRepository;

    public TriangleTypeClassifierUseCaseImpl(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }


    @Override
    public TriangleType execute(Triangle triangle) {
        final Triangle savedTriangle = triangleRepository.save(triangle);
        return savedTriangle.getType();
    }


}
