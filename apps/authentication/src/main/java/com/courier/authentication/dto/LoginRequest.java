package com.courier.authentication.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Incoming login request
public record LoginRequest(
        @NotBlank(message = "Username cannot be blank")
        @Email(message = "Invalid email format")
        String username,
        @NotBlank(message = "Password cannot be blank") String password
) {}