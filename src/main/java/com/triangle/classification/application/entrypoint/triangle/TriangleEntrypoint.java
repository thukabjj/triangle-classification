package com.triangle.classification.application.entrypoint.triangle;

import com.triangle.classification.application.entrypoint.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.usercase.triangle.TriangleCalculateType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/triangle")

public class TriangleEntrypoint {

    private final TriangleCalculateType triangleCalculateType;
    private final TriangleMapper triangleMapper;

    public TriangleEntrypoint(TriangleCalculateType triangleCalculateType, TriangleMapper triangleBuilder) {
        this.triangleCalculateType = triangleCalculateType;
        this.triangleMapper = triangleBuilder;
    }

    @PostMapping("/calculate")
    public ResponseEntity<TriangleEntrypointResponse> calculateTriangleType(@RequestBody @Validated TriangleEntrypointRequest request){
        var triangleType = triangleCalculateType.execute(triangleMapper.toTriangleDomain(request));
        var response = triangleMapper.fromTriangleDomainToResponse(triangleType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
