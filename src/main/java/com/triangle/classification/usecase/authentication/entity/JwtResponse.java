package com.triangle.classification.usecase.authentication.entity;

public record JwtResponse(String username,String token, String type, Long expirationTime) {}
