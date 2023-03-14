package com.example.restaurant.domain.food.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {
    List<Food> findByOwnerId(Long ownerId);

    Food validateFood(Long foodId);
}
