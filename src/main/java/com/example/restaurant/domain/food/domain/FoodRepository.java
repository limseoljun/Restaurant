package com.example.restaurant.domain.food.domain;

import com.example.restaurant.exception.NotFoundFoodException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
    List<Food> findByRestaurantId(Long restaurantId);

    default Food validateFood(Long foodId) {
        Optional<Food> foodMenuOptional = findById(foodId);

        return foodMenuOptional.orElseThrow(NotFoundFoodException::new);
    }
}
