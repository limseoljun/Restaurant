package com.example.restaurant.domain.restaurant.service.add;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;

public interface RestaurantAddService {

    boolean add(RestaurantDto dto, Long ownerId);
}
