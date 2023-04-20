package com.example.restaurant.controller.restaurants.dto;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import lombok.Getter;

@Getter
public class RestaurantUpdateControllerDto {
    private String name;
    private String businessAddress;
    private String callNum;

    public RestaurantUpdateControllerDto(String name, String businessAddress, String callNum) {
        this.name = name;
        this.businessAddress = businessAddress;
        this.callNum = callNum;
    }

    public RestaurantDto convertDto() {
        return new RestaurantDto(this.name, this.businessAddress, this.callNum);
    }
}
