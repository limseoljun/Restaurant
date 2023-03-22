package com.example.restaurant.domain.order.info.service.add;

import com.example.restaurant.domain.servicedto.order.OrderDto;

public interface OrderMoreAddService {
    Long more(Long userId, OrderDto dto);
}
