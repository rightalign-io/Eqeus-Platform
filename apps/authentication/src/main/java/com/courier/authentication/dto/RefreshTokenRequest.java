package com.courier.authentication.dto;

import jakarta.validation.constraints.NotBlank;

// Incoming refresh token request
public record RefreshTokenRequest(
        @NotBlank(message = "Refresh token is required") String refreshToken
) {}
