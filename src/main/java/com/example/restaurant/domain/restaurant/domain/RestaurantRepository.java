package com.example.restaurant.domain.restaurant.domain;

import com.example.restaurant.exception.RestaurantNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    default Restaurant validateOwnerIdAndRestaurantId(Long ownerId, Long restaurantId) {
        Optional<Restaurant> optionalRestaurant = findByOwnerIdAndId(ownerId,restaurantId);
        return optionalRestaurant.orElseThrow(RestaurantNotFoundException::new);
    }

    Optional<Restaurant> findByOwnerIdAndId(Long ownerId, Long restaurantId);

    Optional<Restaurant> findByOwnerId(Long id);

    List<Restaurant> findAllByOwnerId(Long ownerId);

}
