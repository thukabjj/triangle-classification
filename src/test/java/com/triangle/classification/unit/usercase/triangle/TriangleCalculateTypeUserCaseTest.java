package com.triangle.classification.unit.usercase.triangle;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usercase.triangle.TriangleCalculateTypeUserCase;
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
    public void should_return_triangle_type_equilateral(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.EQUILATERAL);
        assertEquals(response.getType(), TriangleType.EQUILATERAL.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_a_equal_side_b(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.ONE,BigDecimal.TEN);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_b_equal_side_c(){
        final Triangle triangle = new Triangle(BigDecimal.TEN,BigDecimal.ONE,BigDecimal.ONE);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_a_equal_side_c(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.TEN,BigDecimal.ONE);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_scalene(){
        final Triangle triangle = new Triangle(BigDecimal.ONE,BigDecimal.TEN,BigDecimal.ZERO);
        final TriangleType response = triangleCalculateTypeUserCase.execute(triangle);
        assertEquals(response, TriangleType.SCALENE);
        assertEquals(response.getType(), TriangleType.SCALENE.getType());
    }

}