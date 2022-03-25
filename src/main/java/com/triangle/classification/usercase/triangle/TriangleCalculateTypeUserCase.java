package com.triangle.classification.usercase.triangle;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usercase.gateway.repository.TriangleRepository;

public class TriangleCalculateTypeUserCase implements TriangleCalculateType {

    private final TriangleRepository triangleRepository;

    public TriangleCalculateTypeUserCase(TriangleRepository triangleRepository) {
        this.triangleRepository = triangleRepository;
    }


    @Override
    public TriangleType execute(Triangle triangle) {

        final TriangleType triangleType = identifyTriangleType(triangle);
        triangle.setType(triangleType);
        triangleRepository.save(triangle);
        return triangleType;

    }

    private TriangleType identifyTriangleType(Triangle triangle) {
        if (triangle.getSideA().equals(triangle.getSideB()) && triangle.getSideA().equals(triangle.getSideC())){

            return TriangleType.EQUILATERAL;
        }
        if (triangle.getSideA().equals(triangle.getSideB()) || triangle.getSideB().equals(triangle.getSideC()) || triangle.getSideC().equals(triangle.getSideA())) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
}
