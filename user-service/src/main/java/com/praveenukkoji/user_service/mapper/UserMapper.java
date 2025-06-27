package com.praveenukkoji.user_service.mapper;

import com.praveenukkoji.user_service.dto.UserResponse;
import com.praveenukkoji.user_service.model.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setFullname(user.getFullname());
        userResponse.setEmail(user.getEmail());

        return userResponse;
    }
}
