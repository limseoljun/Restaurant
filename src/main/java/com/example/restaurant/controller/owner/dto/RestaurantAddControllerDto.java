package com.example.restaurant.controller.owner.dto;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class RestaurantAddControllerDto {
    private final String name;
    private final String businessAddress;
    private final String callNum;


    public RestaurantAddControllerDto(String name, String businessAddress,String callNum) {
        this.name = name;
        this.businessAddress = businessAddress;
        this.callNum = callNum;
    }

    public RestaurantDto convertDto() {
        return new RestaurantDto(this.name,this.businessAddress,this.callNum );
    }
}
