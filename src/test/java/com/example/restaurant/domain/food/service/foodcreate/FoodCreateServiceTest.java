package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperator;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperatorRepository;
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
    private final RestaurantOperatorRepository restaurantOperatorRepository;
    @Autowired
    FoodCreateServiceTest(FoodRepository foodRepository, FoodCreateService foodCreateService, RestaurantOperatorRepository restaurantOperatorRepository) {
        this.foodRepository = foodRepository;
        this.foodCreateService = foodCreateService;
        this.restaurantOperatorRepository = restaurantOperatorRepository;
    }

    @Test
    void 생성_정상작동(){
        FoodDto dto = new FoodDto("name",1000,"info","category");
        RestaurantOperator operator =  new RestaurantOperator("oper","1234","restaurant","123");
        restaurantOperatorRepository.save(operator);
        boolean isCreate = foodCreateService.Create(dto,operator.getId());
        List<Food> list = foodRepository.findByOperId(operator.getId());
        assertTrue(isCreate);
        assertEquals("name",list.get(0).getName());
        assertEquals(1000,list.get(0).getPrice());
        assertEquals("info",list.get(0).getInfo());
        assertEquals("category",list.get(0).getCategory());
    }
}