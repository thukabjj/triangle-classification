package com.triangle.classification.usecase.authentication.entity;

public enum JwtType {

    Bearer("Bearer");

    private String type;


    JwtType(String type) {
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
