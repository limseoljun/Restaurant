package com.example.restaurant.domain.order.info.service.update;

public interface OrderResultUpdateService {
    boolean update(Long userId, Long orderId, String result);
}
