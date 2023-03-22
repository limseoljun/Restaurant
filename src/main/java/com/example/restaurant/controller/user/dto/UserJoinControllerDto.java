package com.example.restaurant.controller.user.dto;

import com.example.restaurant.domain.servicedto.user.UserDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class UserJoinControllerDto {
    @NotBlank(message = "Username is required")
    private final String name;
    @NotBlank(message = "Password is required")
    private final String password;
    @NotBlank
    private final String phoneNum;
    @NotBlank
    private final String nickName;
    @NotBlank
    private final String homeAddress;

    public UserJoinControllerDto(String name, String password, String phoneNum, String nickName, String homeAddress) {
        this.name = name;
        this.password = password;
        this.phoneNum = phoneNum;
        this.nickName = nickName;
        this.homeAddress =homeAddress;
    }

    public UserDto convertDto() {
        return new UserDto(this.name, this.password, this.nickName,this.phoneNum,this.homeAddress);
    }
}
