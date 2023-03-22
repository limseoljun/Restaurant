package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.domain.servicedto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodChangeServiceTest {
    private final FoodRepository foodRepository;
    private final FoodChangeService foodChangeService;
    private final RestaurantRepository restaurantRepository;
    @Autowired
    FoodChangeServiceTest(FoodRepository foodRepository, FoodChangeService foodChangeService, RestaurantRepository restaurantRepository){
        this.foodRepository=foodRepository;
        this.foodChangeService = foodChangeService;
        this.restaurantRepository = restaurantRepository;
    }
    @Test
    void 음식_변경_정상작동() {
        //given
        Restaurant restaurant = new Restaurant("restaurant","123","000",1L);
        restaurantRepository.save(restaurant);
        Food food = new Food("food",1000,"info","category",restaurant.getId());
        foodRepository.save(food);
        FoodDto dto = new FoodDto("food2",2000,"info2","category2");

        //When
        boolean isChange = foodChangeService.Change(food.getId(),dto);
        //then
        assertTrue(isChange);
        assertEquals(food.getName(), dto.getName());
        assertEquals(food.getPrice(), dto.getPrice());
        assertEquals(food.getInfo(), dto.getInfo());
        assertEquals(food.getCategory(), dto.getCategory());
    }

}