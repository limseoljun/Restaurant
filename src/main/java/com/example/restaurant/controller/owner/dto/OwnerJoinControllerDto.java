package com.example.restaurant.controller.owner.dto;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class OwnerJoinControllerDto {
    @NotBlank(message = "Username is required")
    private final String name;
    @NotBlank(message = "Password is required")
    private final String password;

    public OwnerJoinControllerDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public OwnerDto convertDto() {
        return new OwnerDto(this.name, this.password);
    }
}
