package com.example.restaurant.domain.order.menu.service.add;

import com.example.restaurant.domain.servicedto.ordermenu.OrderMenuDto;

public interface OrderMenuAddService {
    void add(Long userId, OrderMenuDto dto);
}
