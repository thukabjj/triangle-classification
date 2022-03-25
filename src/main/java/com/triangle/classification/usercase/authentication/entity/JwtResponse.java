package com.triangle.classification.usercase.authentication.entity;

public record JwtResponse(String username,String token, String type, Long expirationTime) {}
