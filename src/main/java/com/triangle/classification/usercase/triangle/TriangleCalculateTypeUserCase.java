package com.triangle.classification.usercase.triangle;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public class TriangleCalculateTypeUserCase implements TriangleCalculateType {

    @Override
    public TriangleType execute(Triangle triangle) {
        if (triangle.getSideA().equals(triangle.getSideB()) && triangle.getSideA().equals(triangle.getSideC())){
            return TriangleType.EQUILATERAL;
        }
        if (triangle.getSideA().equals(triangle.getSideB()) || triangle.getSideB().equals(triangle.getSideC()) || triangle.getSideC().equals(triangle.getSideA())) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
}
