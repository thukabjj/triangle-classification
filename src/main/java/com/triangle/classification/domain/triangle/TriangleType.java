package com.triangle.classification.domain.triangle;

public enum TriangleType {
    EQUILATERAL("equilateral"),
    ISOSCELES("isosceles"),
    SCALENE("scalene");

    private String type;

    TriangleType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
