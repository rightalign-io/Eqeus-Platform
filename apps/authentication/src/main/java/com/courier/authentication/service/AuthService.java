package com.courier.authentication.service;

import com.courier.authentication.dto.AuthResponse;
import com.courier.authentication.dto.LoginRequest;
import com.courier.authentication.dto.RegisterRequest;
import com.courier.authentication.model.User;
import com.courier.authentication.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
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
        if (!userRepository.existsByEmail(request.username())) {
            throw new RuntimeException("Sorry, your email or password is incorrect!");
        }

        User user = userRepository.findByEmail(request.username());
        boolean passwordMatches =  passwordEncoder.matches(
                request.password(),
                user.getPassword()
        );

        if (!passwordMatches) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Sorry, your email or password is incorrect!"
            );
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                token,
                "---"
        );
    }

    public AuthResponse refreshToken(String refreshToken) {
        return new AuthResponse("new-mock-jwt-access-token", refreshToken);
    }

    public void logout(String refreshToken) {
        // TODO: Handle logout
    }
}