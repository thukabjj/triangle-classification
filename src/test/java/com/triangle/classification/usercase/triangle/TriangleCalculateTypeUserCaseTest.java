package com.triangle.classification.usercase.triangle;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TriangleCalculateTypeUserCaseTest {

    @InjectMocks
    private TriangleCalculateTypeUserCase triangleCalculateTypeUserCase;

    @Test
    public void should_return_triangle_equilateral(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.EQUILATERAL);
    }

    @Test
    public void should_return_triangle_isosceles(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.TEN);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.ISOSCELES);
    }

    @Test
    public void should_return_triangle_scalene(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.TEN,BigDecimal.ZERO);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.SCALENE);
    }

}