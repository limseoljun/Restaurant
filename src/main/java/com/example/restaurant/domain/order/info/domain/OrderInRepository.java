package com.example.restaurant.domain.order.info.domain;

import com.example.restaurant.exception.NotFoundFoodException;
import com.example.restaurant.exception.NotFoundOrderException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderInRepository extends JpaRepository<OrderIn,Long> {

    default OrderIn validateOrder(Long orderId){
        Optional<OrderIn> foodMenuOptional = findById(orderId);

        return foodMenuOptional.orElseThrow(NotFoundFoodException::new);
    };

    boolean existsByUserIdAndId(Long userId, Long orderId);

    Optional<OrderIn> findByIdAndUserId(Long orderId, Long userId);

    List<OrderIn> findByUserId(Long userId);
    boolean existsByUserIdAndResult(Long userId, String result);
    Optional<OrderIn> findByUserIdAndResult(Long userId, String result);

    List<OrderIn> findByResultAndRestaurantId(String ready, Long restaurantId);
}
