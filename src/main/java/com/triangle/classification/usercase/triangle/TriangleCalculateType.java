package com.triangle.classification.usercase.triangle;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

public interface TriangleCalculateType {
    TriangleType execute(Triangle triangle);
}
