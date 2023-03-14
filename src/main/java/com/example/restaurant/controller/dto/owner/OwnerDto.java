package com.example.restaurant.controller.dto.owner;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class OwnerDto {
    @NotBlank(message = "need id")
    private final String name;
    @NotBlank(message = "need password")
    private final String password;
    private final String restaurantName;
    private final String restaurantAddress;

    public OwnerDto(String name, String password, String restaurantName, String restaurantAddress){
        this.name=name;
        this.password=password;
        this.restaurantName=restaurantName;
        this.restaurantAddress=restaurantAddress;
    }
    public OwnerDto(String name, String password){
        this.name=name;
        this.password=password;
        restaurantName = null;
        restaurantAddress = null;
    }
}
