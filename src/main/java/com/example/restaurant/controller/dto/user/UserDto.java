package com.example.restaurant.controller.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDto {
    @NotBlank(message = "need id")
    private final String name;
    @NotBlank(message = "need password")
    private final String password;
    private final String nickName;
    private final String phoneNum;
    private final String homeAddress;
    public UserDto(String name, String password, String nickName, String phoneNum, String homeAddress){
        this.name=name;
        this.password=password;
        this.nickName = nickName;
        this.phoneNum = phoneNum;
        this.homeAddress = homeAddress;
    }
    public UserDto(String name, String password){
        this.name=name;
        this.password=password;
        nickName = null;
        phoneNum = null;
        homeAddress = null;
    }
}
