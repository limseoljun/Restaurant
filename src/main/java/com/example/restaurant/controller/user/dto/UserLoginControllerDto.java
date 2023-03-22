package com.example.restaurant.controller.user.dto;

import com.example.restaurant.domain.servicedto.user.UserDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
@Getter
public class UserLoginControllerDto {
        @NotBlank(message = "Username is required")
        private final String name;
        @NotBlank(message = "Password is required")
        private final String password;

    public UserLoginControllerDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserDto convertDto() {
            return new UserDto(this.name,this.password);
        }
}
