package com.example.restaurant.controller.dto.ordermenu;

import lombok.Data;

@Data
public class OrderMenuDTO {
    private final int count;
    private final Long foodId;
    private final Long orderId;
}
