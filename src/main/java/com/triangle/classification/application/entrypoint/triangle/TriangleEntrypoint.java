package com.triangle.classification.application.entrypoint.triangle;

import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleHistoryEntrypointResponse;
import com.triangle.classification.application.mapper.triangle.TriangleMapper;
import com.triangle.classification.domain.triangle.Triangle;
import com.triangle.classification.usecase.triangle.classifier.TriangleTypeClassifierUseCase;
import com.triangle.classification.usecase.triangle.history.TriangleHistoryUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/triangle")
public class TriangleEntrypoint {

    private final TriangleTypeClassifierUseCase triangleTypeClassifierUseCase;
    private final TriangleHistoryUseCase triangleHistoryUseCase;
    private final TriangleMapper triangleMapper;

    public TriangleEntrypoint(TriangleTypeClassifierUseCase triangleCalculateType, TriangleHistoryUseCase triangleHistoryUseCase, TriangleMapper triangleMapper) {
        this.triangleTypeClassifierUseCase = triangleCalculateType;
        this.triangleHistoryUseCase = triangleHistoryUseCase;
        this.triangleMapper = triangleMapper;
    }

    @PostMapping("/v1/classifier")
    @Operation(summary = "Post - Classifier triangle type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Will returning triangle's type with successful."),
            @ApiResponse(responseCode = "422", description = "Will returning when some parameters have a constraint violation."),
            @ApiResponse(responseCode = "403", description = "User not authorized!")
    })
    public ResponseEntity<TriangleEntrypointResponse> typeIdentifier(@RequestBody @Validated TriangleEntrypointRequest request){
        var triangleType = triangleTypeClassifierUseCase.execute(triangleMapper.fromTriangleEntrypointRequestToTriangleDomain(request));
        var response = triangleMapper.fromTriangleDomainToTriangleEntrypointResponse(triangleType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/v1/history")
    @Operation(summary = "Get - History of Triangles classified.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Will returning list of triangle classified with successful."),
            @ApiResponse(responseCode = "403", description = "User not authorized!")
    })
    public ResponseEntity<List<TriangleHistoryEntrypointResponse>> getHistory(){
        final List<Triangle> triangles = triangleHistoryUseCase.execute();
        final List<TriangleHistoryEntrypointResponse> response = triangleMapper.fromTrianglesToTriangleHistoryEntrypointResponse(triangles);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
