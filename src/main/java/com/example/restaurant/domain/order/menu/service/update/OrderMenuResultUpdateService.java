package com.example.restaurant.domain.order.menu.service.update;

public interface OrderMenuResultUpdateService {
    boolean update(Long userId, Long orderMenuId, String result);
}
