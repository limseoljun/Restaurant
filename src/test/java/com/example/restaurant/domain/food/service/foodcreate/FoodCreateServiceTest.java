package com.example.restaurant.domain.food.service.foodcreate;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodCreateServiceTest {
    private final FoodRepository foodRepository;
    private final FoodCreateService foodCreateService;
    private final RestaurantRepository restaurantRepository;
    @Autowired
    FoodCreateServiceTest(FoodRepository foodRepository, FoodCreateService foodCreateService, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.foodCreateService = foodCreateService;
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    void 생성_정상작동(){
        FoodDto dto = new FoodDto("name",1000,"info","category");
        Restaurant restaurant = new Restaurant("restaurant","1234","12345678",1L);
        restaurantRepository.save(restaurant);

        boolean isCreate = foodCreateService.Create(dto, restaurant.getId());
        List<Food> list = foodRepository.findByRestaurantId(restaurant.getId());

        assertTrue(isCreate);
        assertEquals("name",list.get(0).getName());
        assertEquals(1000,list.get(0).getPrice());
        assertEquals("info",list.get(0).getInfo());
        assertEquals("category",list.get(0).getCategory());
    }
}