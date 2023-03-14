package com.example.restaurant.domain.order.menu.service.add;

import com.example.restaurant.controller.dto.ordermenu.OrderMenuDTO;

public interface OrderMenuAddService {
    void add(Long userId, OrderMenuDTO dto);
}
