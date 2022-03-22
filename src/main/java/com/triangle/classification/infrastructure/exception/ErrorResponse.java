package com.triangle.classification.infrastructure.exception;

import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private Map<String, String> details;
    private int code;
    private String status;

    public ErrorResponse(){}

    public ErrorResponse(Map<String, String> details, int code, String status) {

        this.details = details;
        this.code = code;
        this.status = status;
    }

    public Map<String, String> getDetails() {
        return details;
    }
    public int getCode() {
        return code;
    }
    public String getStatus() {
        return status;
    }


}
