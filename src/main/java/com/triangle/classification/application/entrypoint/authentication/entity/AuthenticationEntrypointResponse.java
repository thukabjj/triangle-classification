package com.triangle.classification.application.entrypoint.authentication.entity;

public record AuthenticationEntrypointResponse(String username,String token, String type, Long expirationTime) {
}
