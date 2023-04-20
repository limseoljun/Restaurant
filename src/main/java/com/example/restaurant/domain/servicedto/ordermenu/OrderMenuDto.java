package com.example.restaurant.domain.servicedto.ordermenu;

import lombok.Data;

@Data
public class OrderMenuDto {
    private final int count;
    private final Long foodId;
    private final Long orderId;

    public OrderMenuDto(Long foodId,int count,Long orderId){
        this.count=count;
        this.foodId=foodId;
        this.orderId=orderId;
    }
}
