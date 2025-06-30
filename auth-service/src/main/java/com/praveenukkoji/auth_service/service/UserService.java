package com.praveenukkoji.auth_service.service;

import com.praveenukkoji.auth_service.exception.UserNotFoundException;
import com.praveenukkoji.auth_service.model.User;
import com.praveenukkoji.auth_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()) {
            throw new UserNotFoundException("user not found");
        }

        return user;
    }
}
