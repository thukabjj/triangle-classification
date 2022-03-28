package com.triangle.classification.application.mapper.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleHistoryEntrypointResponse;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.domain.triangle.TriangleType;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TriangleMapperImpl implements TriangleMapper {

    @Override
    public Triangle fromTriangleEntrypointRequestToTriangleDomain(TriangleEntrypointRequest request) {
        return new Triangle(request.sideA(), request.sideB(), request.sideC());
    }

    @Override
    public TriangleEntrypointResponse fromTriangleDomainToTriangleEntrypointResponse(TriangleType triangleType) {
        return new TriangleEntrypointResponse(triangleType.getType());
    }

    @Override
    public TriangleEntity fromTriangleDomainToTriangleDAO(Triangle triangle) {
        return new TriangleEntity(String.valueOf(triangle.getSideA()), String.valueOf(triangle.getSideB()), String.valueOf(triangle.getSideC()), triangle.getType().getType());
    }

    @Override
    public Triangle fromTriangleDAOToTriangleDomain(TriangleEntity trianglesDAO) {
        final TriangleType triangleType = TriangleType.getTriangleType(trianglesDAO.getType());
        return new Triangle(trianglesDAO.getId(), new BigDecimal(trianglesDAO.getSideA()), new BigDecimal(trianglesDAO.getSideB()), new BigDecimal(trianglesDAO.getSideC()), triangleType);
    }

    @Override
    public List<TriangleHistoryEntrypointResponse> fromTrianglesToTriangleHistoryEntrypointResponse(List<Triangle>  triangles) {
        return triangles.stream().map(t -> new TriangleHistoryEntrypointResponse(t.getId(),t.getSideA(), t.getSideB(), t.getSideC(), t.getType().getType())).collect(Collectors.toList());
    }

    @Override
    public List<Triangle> fromTrianglesDAOToTrianglesDomain(Iterable<TriangleEntity> trianglesDAO) {
        List<TriangleEntity> trianglesDAOList = (List<TriangleEntity>) trianglesDAO;
        List<Triangle> triangles = new ArrayList<>();
        if (Objects.nonNull(trianglesDAOList) && !trianglesDAOList.isEmpty()) {
            triangles = trianglesDAOList.stream().map(t ->
                    new Triangle(t.getId(), new BigDecimal(t.getSideA()), new BigDecimal(t.getSideB()), new BigDecimal(t.getSideC()), TriangleType.getTriangleType(t.getType()))
            ).collect(Collectors.toList());
        }
        return triangles;
    }
}
