package com.triangle.classification.unit.application.entrypoint.triangle;

import com.triangle.classification.application.entrypoint.triangle.TriangleEntrypoint;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleHistoryEntrypointResponse;
import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;
import com.triangle.classification.usercase.triangle.classifier.TriangleTypeClassifierUserCase;
import com.triangle.classification.usercase.triangle.history.TriangleHistoryUserCase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TriangleEntrypointTest {

    @InjectMocks
    private TriangleEntrypoint entrypoint;

    @Mock
    private TriangleTypeClassifierUserCase triangleTypeClassifierUserCase;

    @Mock
    private TriangleHistoryUserCase triangleHistoryUserCase;

    @Mock
    private TriangleMapper triangleMapper;

    @Test
    public void should_returning_triangle_equilateral_classification_with_successful() {
        //Given
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.EQUILATERAL.getType());
        final Triangle triangle = new Triangle(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        //When
        when(triangleMapper.fromTriangleEntrypointRequestToTriangleDomain(any(TriangleEntrypointRequest.class))).thenReturn(triangle);
        when(triangleTypeClassifierUserCase.execute(any(Triangle.class))).thenReturn(TriangleType.EQUILATERAL);
        when(triangleMapper.fromTriangleDomainToTriangleEntrypointResponse(any(TriangleType.class))).thenReturn(expected);
        //Then
        ResponseEntity<TriangleEntrypointResponse> response = entrypoint.typeIdentifier(request);

        Assertions.assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void should_returning_triangle_isosceles_classification_with_successful() {
        //Given
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE);
        TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.ISOSCELES.getType());
        final Triangle triangle = new Triangle(BigDecimal.TEN, BigDecimal.ONE, BigDecimal.ONE);
        //When
        when(triangleMapper.fromTriangleEntrypointRequestToTriangleDomain(any(TriangleEntrypointRequest.class))).thenReturn(triangle);
        when(triangleTypeClassifierUserCase.execute(any(Triangle.class))).thenReturn(TriangleType.ISOSCELES);
        when(triangleMapper.fromTriangleDomainToTriangleEntrypointResponse(any(TriangleType.class))).thenReturn(expected);
        //Then
        ResponseEntity<TriangleEntrypointResponse> response = entrypoint.typeIdentifier(request);

        Assertions.assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void should_returning_triangle_scalene_classification_with_successful() {
        //Given
        TriangleEntrypointRequest request = new TriangleEntrypointRequest(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO);
        TriangleEntrypointResponse expected = new TriangleEntrypointResponse(TriangleType.SCALENE.getType());
        final Triangle triangle = new Triangle(BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO);
        //When
        when(triangleMapper.fromTriangleEntrypointRequestToTriangleDomain(any(TriangleEntrypointRequest.class))).thenReturn(triangle);
        when(triangleTypeClassifierUserCase.execute(any(Triangle.class))).thenReturn(TriangleType.SCALENE);
        when(triangleMapper.fromTriangleDomainToTriangleEntrypointResponse(any(TriangleType.class))).thenReturn(expected);
        //Then
        ResponseEntity<TriangleEntrypointResponse> response = entrypoint.typeIdentifier(request);

        Assertions.assertThat(response.getBody()).isEqualTo(expected);
    }

    @Test
    public void should_returning_history_of_triangles_classified_with_successful() {
        //Given
        List<TriangleHistoryEntrypointResponse> expected = new ArrayList<>();
        expected.add(new TriangleHistoryEntrypointResponse("", BigDecimal.ONE, BigDecimal.TEN, BigDecimal.ZERO, TriangleType.SCALENE.getType()));

        //When
        doReturn(expected).when(triangleMapper).fromTrianglesToTriangleHistoryEntrypointResponse(anyList());

        //Then
        final ResponseEntity<List<TriangleHistoryEntrypointResponse>> response = entrypoint.getHistory();
        Assertions.assertThat(response.getBody()).isEqualTo(expected);

    }
}
