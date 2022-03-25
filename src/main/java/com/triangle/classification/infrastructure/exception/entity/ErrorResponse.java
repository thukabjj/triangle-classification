package com.triangle.classification.infrastructure.exception.entity;

import java.util.Map;

public class ErrorResponse {
    private Map<String, String> details;
    private int code;
    private String status;



    public ErrorResponse(Map<String, String> details, int code, String status) {

        this.details = details;
        this.code = code;
        this.status = status;
    }

    public Map<String, String> getDetails() {
        return details;
    }



}
