package com.courier.authentication.service;

import com.courier.authentication.dto.AuthResponse;
import com.courier.authentication.dto.LoginRequest;
import com.courier.authentication.dto.RegisterRequest;
import com.courier.authentication.model.User;
import com.courier.authentication.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("A user with this email already exists!");
        }

        User user = User.builder()
                .name(request.name())
                .surname(request.surname())
                .email(request.email())
                .password(passwordEncoder.encode(request.password())) // Secure hash
                .phoneNumber(request.phoneNumber())
                .address(request.address())
                .profilePicture(request.profilePicture())
                .build();

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {
        // TODO: Implement login verification against userRepository
        return new AuthResponse("mock-jwt-access-token", "mock-jwt-refresh-token");
    }

    public AuthResponse refreshToken(String refreshToken) {
        return new AuthResponse("new-mock-jwt-access-token", refreshToken);
    }

    public void logout(String refreshToken) {
        // TODO: Handle logout
    }
}