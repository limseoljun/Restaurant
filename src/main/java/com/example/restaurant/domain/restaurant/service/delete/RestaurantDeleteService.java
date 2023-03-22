package com.example.restaurant.domain.restaurant.service.delete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;

public interface RestaurantDeleteService {
    boolean delete(Long restaurantId, OwnerDto dto);
}
