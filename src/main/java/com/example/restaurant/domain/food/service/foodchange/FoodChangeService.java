package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.domain.servicedto.food.FoodDto;

public interface FoodChangeService {
    boolean Change(Long foodId, FoodDto dto);
}
