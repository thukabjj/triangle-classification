package com.triangle.classification.application.entrypoint.triangle.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public record TriangleEntrypointRequest (@NotNull @Min(value=0) BigDecimal sideA, @NotNull @Min(value=0) BigDecimal sideB, @NotNull @Min(value=0) BigDecimal sideC){}
