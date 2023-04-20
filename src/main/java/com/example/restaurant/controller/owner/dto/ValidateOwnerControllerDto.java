package com.example.restaurant.controller.owner.dto;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import lombok.Getter;

@Getter
public class ValidateOwnerControllerDto {
    private final String name;
    private final String password;

    public ValidateOwnerControllerDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public OwnerDto convertDto(){return new OwnerDto(this.name,this.password);}
}
