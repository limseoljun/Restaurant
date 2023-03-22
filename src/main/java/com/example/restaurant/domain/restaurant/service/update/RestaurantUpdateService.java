package com.example.restaurant.domain.restaurant.service.update;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;

public interface RestaurantUpdateService {
    boolean update(Long restaurantId, RestaurantDto dto);
}
