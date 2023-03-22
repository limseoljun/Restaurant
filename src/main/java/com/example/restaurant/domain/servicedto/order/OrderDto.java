package com.example.restaurant.domain.servicedto.order;

import com.example.restaurant.domain.servicedto.ordermenu.OrderMenuDto;
import lombok.Data;

@Data
public class OrderDto {
    private final Long restaurantId;
    private final Long foodId;
    private final int count;

    public OrderDto(Long restaurantId,Long foodId,int count){
        this.restaurantId=restaurantId;
        this.foodId=foodId;
        this.count=count;
    }
    public OrderMenuDto convertOrderMenuDto(Long orderId){
        return new OrderMenuDto(
                this.count,
            this.foodId,
                orderId
            );
    }
}
