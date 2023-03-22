package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.exception.OwnerNameAndPasswordDifferentException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodDeleteServiceTest {
    private final FoodRepository foodRepository;
    private final FoodDeleteService foodDeleteService;
    private final RestaurantRepository restaurantRepository;

    private final OwnerRepository ownerRepository;

    @Autowired
    FoodDeleteServiceTest(FoodRepository foodRepository, FoodDeleteService foodDeleteService, RestaurantRepository restaurantRepository, OwnerRepository ownerRepository) {
        this.foodRepository = foodRepository;
        this.foodDeleteService = foodDeleteService;
        this.restaurantRepository = restaurantRepository;
        this.ownerRepository = ownerRepository;
    }

    //Owner 대신 restaurant 고유번호로 바꾸기
    @Test
    void 삭제_정상작동(){
        Owner owner = new Owner("owner","1234");
        ownerRepository.save(owner);
        Restaurant restaurant =  new Restaurant("restaurant","123","000",owner.getId());
        restaurantRepository.save(restaurant);
        OwnerDto dto = new OwnerDto("owner","1234");
        Food food = new Food("name",1000,"info","category", restaurant.getId());
        foodRepository.save(food);

        boolean isDelete = foodDeleteService.delete(food.getId(),dto);

        assertTrue(isDelete);
        assertFalse(foodRepository.existsById(food.getId()));
    }

    @Test
    void 삭제_다른_아이디(){
        Owner owner = new Owner("owner","1234");
        ownerRepository.save(owner);
        Restaurant restaurant =  new Restaurant("restaurant","123","000",owner.getId());
        restaurantRepository.save(restaurant);
        OwnerDto dto = new OwnerDto("owner2","12345");
        Food food = new Food("name",1000,"info","category", restaurant.getId());
        foodRepository.save(food);

        OwnerNameAndPasswordDifferentException e = assertThrows(OwnerNameAndPasswordDifferentException.class, () ->
                    foodDeleteService.delete(food.getId(),dto)
                );

        assertEquals("Different Owner Name And Password", e.getMessage());
    }
}