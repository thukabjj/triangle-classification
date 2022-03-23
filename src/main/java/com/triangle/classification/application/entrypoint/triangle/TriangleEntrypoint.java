package com.triangle.classification.application.entrypoint.triangle;

import com.triangle.classification.application.entrypoint.exception.ErrorResponse;
import com.triangle.classification.application.entrypoint.mapper.triangle.TriangleMapper;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointRequest;
import com.triangle.classification.application.entrypoint.triangle.entity.TriangleEntrypointResponse;
import com.triangle.classification.usercase.triangle.TriangleCalculateType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/triangle")
public class TriangleEntrypoint {

    private final TriangleCalculateType triangleCalculateType;
    private final TriangleMapper triangleMapper;

    public TriangleEntrypoint(TriangleCalculateType triangleCalculateType, TriangleMapper triangleBuilder) {
        this.triangleCalculateType = triangleCalculateType;
        this.triangleMapper = triangleBuilder;
    }

    @PostMapping("/v1/calculate")
    @Operation(summary = "Post - Calculate triangle type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Will returning triangle's type with successful.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = TriangleEntrypointResponse.class)) }),
            @ApiResponse(responseCode = "422", description = "Will returning when some parameters have a constraint violation.",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)) })
    })
    public ResponseEntity<TriangleEntrypointResponse> calculateTriangleType(@RequestBody @Validated TriangleEntrypointRequest request){
        var triangleType = triangleCalculateType.execute(triangleMapper.toTriangleDomain(request));
        var response = triangleMapper.fromTriangleDomainToResponse(triangleType);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
