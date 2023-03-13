package com.example.restaurant.domain.restaurantoperator.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantOperatorRepository extends JpaRepository <RestaurantOperator,Long>{

    boolean existsByName(String name);
    boolean existsByPassword(String password);

    boolean existsByNameAndPassword(String name, String password);
}
