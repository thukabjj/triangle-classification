package com.triangle.classification.application.database.dynamo.triangle;

import com.triangle.classification.application.database.dynamo.triangle.entity.TriangleEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface TriangleDAO extends CrudRepository<TriangleEntity, String> {
}
