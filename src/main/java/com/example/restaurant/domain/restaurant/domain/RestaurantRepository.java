package com.example.restaurant.domain.restaurant.domain;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.exception.OwnerNameNotFoundException;
import com.example.restaurant.exception.RestaurantIdNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    default Restaurant validateOwnerId(Long ownerId) {
        Optional<Restaurant> optionalRestaurant = findByOwnerId(ownerId);
        return optionalRestaurant.orElseThrow(RestaurantIdNotFoundException::new);
    }

    Optional<Restaurant> findByOwnerId(Long id);

    List<Restaurant> findAllByOwnerId(Long ownerId);

}
