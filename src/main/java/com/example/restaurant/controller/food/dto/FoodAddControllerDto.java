package com.example.restaurant.controller.food.dto;

import com.example.restaurant.domain.servicedto.food.FoodDto;
import lombok.Getter;

@Getter
public class FoodAddControllerDto {
    private String name;
    private int price;
    private String info;
    private String category;

    public FoodAddControllerDto(String name,int price,String info,String category){
        this.name=name;
        this.price=price;
        this.info=info;
        this.category=category;
    }
    public FoodDto convertDto(){
        return new FoodDto(this.name,this.price,this.info,this.category);
    }
}
