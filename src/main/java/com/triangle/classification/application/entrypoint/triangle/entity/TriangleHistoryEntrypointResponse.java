package com.triangle.classification.application.entrypoint.triangle.entity;

import java.math.BigDecimal;

public record TriangleHistoryEntrypointResponse(String id, BigDecimal sideA,  BigDecimal sideB,  BigDecimal sideC, String type) {}
