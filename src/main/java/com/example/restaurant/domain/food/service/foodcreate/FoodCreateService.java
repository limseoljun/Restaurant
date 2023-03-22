package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.domain.servicedto.food.FoodDto;

public interface FoodCreateService {
    boolean Create(FoodDto dto, Long restaurantId);
}
