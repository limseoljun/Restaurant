package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.oper.OperDto;
import com.example.restaurant.controller.dto.user.UserDto;

public interface FoodDeleteService {
    boolean Delete(Long foodId, OperDto dto);
}
