package com.triangle.classification.usercase.triangle.classifier;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usercase.gateway.repository.TriangleRepository;

public class TriangleTypeClassifierUserCaseImpl implements TriangleTypeClassifierUserCase {

    private final TriangleRepository triangleRepository;

    public TriangleTypeClassifierUserCaseImpl(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }


    @Override
    public TriangleType execute(Triangle triangle) {
        final Triangle savedTriangle = triangleRepository.save(triangle);
        return savedTriangle.getType();
    }


}
