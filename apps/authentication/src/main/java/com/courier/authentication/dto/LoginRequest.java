package com.courier.authentication.dto;

import jakarta.validation.constraints.NotBlank;

// Incoming login request
public record LoginRequest(
        @NotBlank(message = "Username cannot be blank") String username,
        @NotBlank(message = "Password cannot be blank") String password
) {}