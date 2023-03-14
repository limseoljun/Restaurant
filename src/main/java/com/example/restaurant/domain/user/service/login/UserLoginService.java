package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.controller.dto.user.UserDto;

public interface UserLoginService {
    Long validate(UserDto dto);
}

