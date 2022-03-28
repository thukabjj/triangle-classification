package com.triangle.classification.usercase.triangle.classifier;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public interface TriangleTypeClassifierUserCase {
    TriangleType execute(Triangle triangle);
}
