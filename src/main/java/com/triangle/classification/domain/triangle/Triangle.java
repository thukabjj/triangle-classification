package com.triangle.classification.domain.triangle;

import java.math.BigDecimal;

public class Triangle {

    private Long id;
    private BigDecimal sideA;
    private BigDecimal sideB;
    private BigDecimal sideC;
    private TriangleType type;

    public Triangle() {
    }

    public Triangle(Long id, BigDecimal sideA, BigDecimal sideB, BigDecimal sideC, TriangleType type) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSideA() {
        return sideA;
    }

    public void setSideA(BigDecimal sideA) {
        this.sideA = sideA;
    }

    public BigDecimal getSideB() {
        return sideB;
    }

    public void setSideB(BigDecimal sideB) {
        this.sideB = sideB;
    }

    public BigDecimal getSideC() {
        return sideC;
    }

    public void setSideC(BigDecimal sideC) {
        this.sideC = sideC;
    }

    public TriangleType getType() {
        return type;
    }

    public void setType(TriangleType type) {
        this.type = type;
    }


}
