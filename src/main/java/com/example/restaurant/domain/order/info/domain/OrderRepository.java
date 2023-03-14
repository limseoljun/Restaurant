package com.example.restaurant.domain.order.info.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order validateOrder(Long orderId);
}
