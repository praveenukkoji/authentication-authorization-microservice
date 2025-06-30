package com.praveenukkoji.auth_service.service;

import com.praveenukkoji.auth_service.Utils.JwtUtil;
import com.praveenukkoji.auth_service.dto.LoginRequest;
import com.praveenukkoji.auth_service.exception.UserNotFoundException;
import com.praveenukkoji.auth_service.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> authenticate(LoginRequest loginRequest) {
        Optional<User> user = userService.findByEmail(loginRequest.getEmail());

        if(user.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }

        Optional<String> token = user.filter(
                u -> passwordEncoder.matches(loginRequest.getPassword(), u.getPassword())
                ).map(u -> jwtUtil.generateToken(u.getEmail(), u.getRole()));

        return token;
    }

    public boolean validateToken(String authHeader) {
        String token = authHeader.substring(7);

        try {
            jwtUtil.validate(token);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }
}
