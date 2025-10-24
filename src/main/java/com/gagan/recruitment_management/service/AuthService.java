package com.gagan.recruitment_management.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gagan.recruitment_management.repository.UserRepository;
import com.gagan.recruitment_management.model.User;
import com.gagan.recruitment_management.dto.LoginRequest;
import com.gagan.recruitment_management.dto.SignupRequest;
import com.gagan.recruitment_management.config.JwtUtils;
import org.springframework.http.ResponseEntity;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtUtils jwtUtils;

    public ResponseEntity<?> registerUser(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole(request.getUserType());
        user.setProfileHeadline(request.getProfileHeadline());
        user.setAddress(request.getAddress());
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                .orElse(null);
        if (user == null || !encoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
        String token = jwtUtils.generateJwtToken(user);
        return ResponseEntity.ok(token);
    }
}
