package com.triangle.classification.usecase.triangle.classifier;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public interface TriangleTypeClassifierUseCase {
    TriangleType execute(Triangle triangle);
}
