package com.example.restaurant.domain.servicedto.owner;

import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class OwnerDto {
    @NotBlank(message = "need id")
    private final String name;
    @NotBlank(message = "need password")
    private final String password;

    public OwnerDto(String name, String password){
        this.name=name;
        this.password=password;
    }
}
