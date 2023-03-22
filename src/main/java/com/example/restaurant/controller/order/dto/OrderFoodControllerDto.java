package com.example.restaurant.controller.order.dto;

import com.example.restaurant.domain.servicedto.order.OrderDto;
import lombok.Getter;

@Getter
public class OrderFoodControllerDto {
    private Long restaurantId;
    private Long foodId;
    private int count;

    public OrderFoodControllerDto(Long restaurantId,Long foodId,int count){
        this.restaurantId=restaurantId;
        this.count=count;
        this.foodId=foodId;
    }
    public OrderDto convertDto() {
        return new OrderDto(this.restaurantId,this.foodId,this.count);
    }
}
