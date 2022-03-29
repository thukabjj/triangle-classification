package com.triangle.classification.usecase.triangle.classifier;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usecase.gateway.repository.TriangleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TriangleTypeClassifierUseCaseImplTest {

    @InjectMocks
    private TriangleTypeClassifierUseCaseImpl triangleTypeClassifierUseCase;

    @Mock
    private TriangleRepository triangleRepository;

    @Test
    public void should_return_triangle_type_equilateral() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, TriangleType.EQUILATERAL);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.EQUILATERAL);
        assertEquals(response.getType(), TriangleType.EQUILATERAL.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_a_equal_side_b() {

        //Given
        final Triangle triangle = new Triangle(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_a_equal_side_c() {

        //Given
        final Triangle triangle = new Triangle(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }
    @Test
    public void should_return_triangle_type_isosceles_side_b_equal_side_a() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.TEN, TriangleType.ISOSCELES);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_b_equal_side_c() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE, TriangleType.ISOSCELES);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_c_equal_side_a() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, TriangleType.ISOSCELES);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }

    @Test
    public void should_return_triangle_type_isosceles_side_c_equal_side_b() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE, TriangleType.ISOSCELES);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        //Then
        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        assertEquals(response, TriangleType.ISOSCELES);
        assertEquals(response.getType(), TriangleType.ISOSCELES.getType());
    }


    @Test
    public void should_return_triangle_type_scalene() {

        //Given
        final Triangle triangle = new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, TriangleType.SCALENE);

        //When
        when(triangleRepository.save(any(Triangle.class))).thenReturn(triangle);

        final TriangleType response = triangleTypeClassifierUseCase.execute(triangle);

        //Then
        assertEquals(response, TriangleType.SCALENE);
        assertEquals(response.getType(), TriangleType.SCALENE.getType());
    }

}