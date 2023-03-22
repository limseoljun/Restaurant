package com.example.restaurant.domain.user.service.login;

import com.example.restaurant.domain.servicedto.user.UserDto;

public interface UserLoginService {
    Long validate(UserDto dto);
}

