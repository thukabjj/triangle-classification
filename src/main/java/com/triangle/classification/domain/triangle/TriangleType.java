package com.triangle.classification.domain.triangle;

public enum TriangleType {
    EQUILATERAL("equilateral"),
    ISOSCELES("isosceles"),
    SCALENE("scalene"),
    DEFAULT("undefined");

    private String type;

    TriangleType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public static TriangleType getTriangleType(String type){
        TriangleType triangleType = DEFAULT;
        for (TriangleType t : TriangleType.values()) {
            if(t.getType().equals(type)){
                triangleType = t;
            }
        }
        return triangleType;
    }
}
