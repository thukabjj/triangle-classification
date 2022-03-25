package com.triangle.classification.application.mapper.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleMapperImpl implements TriangleMapper {

    @Override
    public Triangle toTriangleDomain(TriangleEntrypointRequest request) {
        final Triangle triangle = new Triangle(request.sideA(),request.sideB(),request.sideC());
        return triangle;
    }

    @Override
    public TriangleEntrypointResponse fromTriangleDomainToResponse(TriangleType triangleType) {
        return new TriangleEntrypointResponse(triangleType.getType());
    }

    @Override
    public TriangleEntity fromTriangleDomainToTriangleDAO(Triangle triangle) {
        return new TriangleEntity(String.valueOf(triangle.getSideA()),String.valueOf(triangle.getSideB()),String.valueOf(triangle.getSideC()),triangle.getType().getType());
    }

    @Override
    public Triangle fromTriangleDAOToTriangleDomain(TriangleEntity trianglesDAO) {

        return new Triangle(trianglesDAO.getId(), new BigDecimal(trianglesDAO.getSideA()),new BigDecimal(trianglesDAO.getSideB()),new BigDecimal(trianglesDAO.getSideC()), TriangleType.EQUILATERAL);
    }

    @Override
    public List<Triangle> fromTrianglesDAOToTrianglesDomain(Iterable<TriangleEntity>trianglesDAO) {
        List<TriangleEntity> trianglesDAOList = new ArrayList();
        trianglesDAO.forEach(trianglesDAOList::add);
        final List<Triangle> triangles = trianglesDAOList.stream().map(t ->
            new Triangle(t.getId(), new BigDecimal(t.getSideA()),new BigDecimal(t.getSideB()),new BigDecimal(t.getSideC()), TriangleType.EQUILATERAL)
        ).collect(Collectors.toList());
        return triangles;
    }
}
