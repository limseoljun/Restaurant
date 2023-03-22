package com.example.restaurant.domain.servicedto.restaurant;

import lombok.Data;

@Data
public class RestaurantDto {
    private final String name;
    private final String businessAddress;
    private final String callNum;

    public RestaurantDto (String name,String businessAddress,String callNum){
        this.name=name;
        this.businessAddress=businessAddress;
        this.callNum=callNum;
    }
}

