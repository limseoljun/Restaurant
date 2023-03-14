package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.owner.OwnerDto;

public interface FoodDeleteService {
    boolean Delete(Long foodId, OwnerDto dto);
}
