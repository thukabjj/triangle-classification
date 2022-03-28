package com.triangle.classification.application.database.dynamo.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.usercase.gateway.repository.TriangleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DynamoRepositoryImpl implements TriangleRepository {

    private final TriangleMapper triangleMapper;

    private final TriangleDAO triangleDAO;

    public DynamoRepositoryImpl(TriangleMapper triangleMapper, TriangleDAO triangleDAO) {
        this.triangleMapper = triangleMapper;
        this.triangleDAO = triangleDAO;
    }
    
    @Override
    public Triangle save(Triangle triangle) {
        final TriangleEntity triangleEntity = triangleMapper.fromTriangleDomainToTriangleDAO(triangle);
        final TriangleEntity savedEntity = triangleDAO.save(triangleEntity);
        return triangleMapper.fromTriangleDAOToTriangleDomain(savedEntity);
    }

    @Override
    public List<Triangle> getAllTriangles(){
        final Iterable<TriangleEntity> trianglesDAO = triangleDAO.findAll();
        return triangleMapper.fromTrianglesDAOToTrianglesDomain(trianglesDAO);
    }
}
