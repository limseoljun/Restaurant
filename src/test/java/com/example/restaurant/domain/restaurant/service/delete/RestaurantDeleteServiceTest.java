package com.example.restaurant.domain.restaurant.service.delete;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RestaurantDeleteServiceTest {
    private final RestaurantDeleteService restaurantDeleteService;
    private final OwnerRepository ownerRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantDeleteServiceTest(RestaurantDeleteService restaurantDeleteService, OwnerRepository ownerRepository, RestaurantRepository restaurantRepository) {
        this.restaurantDeleteService = restaurantDeleteService;
        this.ownerRepository = ownerRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    void 식당_삭제_정상작동(){
        Owner owner = new Owner("owner","123");
        ownerRepository.save(owner);
        Restaurant restaurant = new Restaurant("restaurant","address","000",owner.getId());
        restaurantRepository.save(restaurant);
        OwnerDto ownerDto = new OwnerDto("owner","123");

        boolean isDelete = restaurantDeleteService.delete(restaurant.getId(),ownerDto);

        assertTrue(isDelete);
        assertFalse(restaurantRepository.existsById(restaurant.getId()));
    }

}