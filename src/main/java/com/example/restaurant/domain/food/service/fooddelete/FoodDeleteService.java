package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;

public interface FoodDeleteService {
    boolean delete(Long foodId, OwnerDto dto);
}
