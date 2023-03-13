package com.example.restaurant.domain.user.service.join;

import com.example.restaurant.controller.dto.user.UserDto;

public interface UserJoinService {
    void validateJoin(UserDto dto);
}
