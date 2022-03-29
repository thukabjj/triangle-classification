package com.triangle.classification.usecase.triangle.history;

import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usecase.gateway.repository.TriangleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TriangleHistoryUseCaseImplTest {

    @InjectMocks
    private TriangleHistoryUseCaseImpl triangleHistoryUseCase;

    @Mock
    private TriangleRepository triangleRepository;

    @Test
    public void should_return_history_of_triangles() {

        //Given
        final List<Triangle> expected = List.of(
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, TriangleType.EQUILATERAL),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ONE, TriangleType.ISOSCELES),
                new Triangle("642403e1-f980-4a14-9729-e8b4487ea522", BigDecimal.TEN, BigDecimal.ZERO, BigDecimal.ONE, TriangleType.SCALENE)
        );

        //When
        when(triangleRepository.getAllTriangles()).thenReturn(expected);

        //Then
        final List<Triangle> response = triangleHistoryUseCase.execute();

        Assertions.assertThat(response).usingRecursiveComparison()
                .isEqualTo(expected);
    }

}
