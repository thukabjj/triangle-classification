package com.triangle.classification.domain.triangle;

import java.math.BigDecimal;

public class Triangle {

    private Long id;
    private BigDecimal sideA;
    private BigDecimal sideB;
    private BigDecimal sideC;
    private TriangleType type;


    public Triangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    public BigDecimal getSideA() {
        return sideA;
    }

    public BigDecimal getSideB() {
        return sideB;
    }

    public BigDecimal getSideC() {
        return sideC;
    }


}
