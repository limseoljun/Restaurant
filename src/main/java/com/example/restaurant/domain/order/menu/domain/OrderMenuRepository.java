package com.example.restaurant.domain.order.menu.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderMenuRepository extends JpaRepository<OrderMenu,Long> {
    boolean existsByUserIdAndId(Long userId, Long orderMenuId);

    Optional<OrderMenu> findByIdAndUserId(Long orderInId, Long userId);

    List<OrderMenu> findByOrderInId(Long orderInId);

    Optional<OrderMenu> findByFoodIdAndOrderInId(Long foodId,Long orderId);

    default OrderMenu existingOrderMenu(Long foodId, Long orderId){
        Optional<OrderMenu> orderMenuOptional = findByFoodIdAndOrderInId(foodId,orderId);
        return orderMenuOptional.orElse(null);
    }
}
