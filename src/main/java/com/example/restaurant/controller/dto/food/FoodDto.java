package com.example.restaurant.controller.dto.food;

import lombok.Data;

@Data
public class FoodDto {
    private final String name;
    private final int price;
    private final String info;
    private final String category;
    public FoodDto(String name,int price,String info,String category){
        this.name=name;
        this.price=price;
        this.info=info;
        this.category=category;
    }
}
