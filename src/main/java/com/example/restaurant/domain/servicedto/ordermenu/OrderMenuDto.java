package com.example.restaurant.domain.servicedto.ordermenu;

import lombok.Data;

@Data
public class OrderMenuDto {
    private final int count;
    private final Long foodId;
    private final Long orderId;
}
