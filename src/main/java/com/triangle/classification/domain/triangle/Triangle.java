package com.triangle.classification.domain.triangle;

import java.math.BigDecimal;

public class Triangle {

    private String id;
    private BigDecimal sideA;
    private BigDecimal sideB;
    private BigDecimal sideC;
    private TriangleType type;


    public Triangle(String id, BigDecimal sideA, BigDecimal sideB, BigDecimal sideC, TriangleType type) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.type = type;
    }

    public Triangle(BigDecimal sideA, BigDecimal sideB, BigDecimal sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.type = identifyTriangleType();
    }

    public String getId() {
        return id;
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

    public TriangleType getType() {
        return type;
    }

    private TriangleType identifyTriangleType() {
        if (this.sideA.equals(this.sideB) && this.sideA.equals(this.sideC)){
            return TriangleType.EQUILATERAL;
        }
        if (this.sideA.equals(this.sideB) ||this.sideB.equals(this.sideC) || this.sideC.equals(this.sideA)) {
            return TriangleType.ISOSCELES;
        }
        return TriangleType.SCALENE;
    }
}
