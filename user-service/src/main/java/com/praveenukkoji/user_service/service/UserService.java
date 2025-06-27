package com.praveenukkoji.user_service.service;

import com.praveenukkoji.user_service.dto.UserResponse;
import com.praveenukkoji.user_service.exception.UserNotFoundException;
import com.praveenukkoji.user_service.mapper.UserMapper;
import com.praveenukkoji.user_service.model.User;
import com.praveenukkoji.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(User user) {
        return UserMapper.toUserResponse(userRepository.save(user));
    }


    public UserResponse getUser(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        return UserMapper.toUserResponse(user);
    }

    public List<UserResponse> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toUserResponse).toList();
    }
}
