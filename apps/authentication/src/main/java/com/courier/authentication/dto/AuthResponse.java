package com.courier.authentication.dto;

// Outgoing response containing the tokens
public record AuthResponse(
        String accessToken,
        String refreshToken
) {}
