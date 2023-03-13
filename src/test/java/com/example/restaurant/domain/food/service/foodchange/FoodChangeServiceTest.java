package com.example.restaurant.domain.food.service.foodchange;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodChangeServiceTest {
    private final FoodRepository foodRepository;
    private final FoodChangeService foodChangeService;
    private final RestaurantOperatorRepository restaurantOperatorRepository;
    @Autowired
    FoodChangeServiceTest(FoodRepository foodRepository, FoodChangeService foodChangeService, RestaurantOperatorRepository restaurantOperatorRepository){
        this.foodRepository=foodRepository;
        this.foodChangeService = foodChangeService;
        this.restaurantOperatorRepository = restaurantOperatorRepository;
    }
    @Test
    void 음식_변경_정상작동() {
        //given
        RestaurantOperator oper = new RestaurantOperator("사업자","1234","가게이름","123");
        restaurantOperatorRepository.save(oper);
        Food food = new Food("음식이름",1000,"음식정보","음식종류",oper.getId());
        foodRepository.save(food);
        //When
        FoodDto dto = new FoodDto("음식이름2",2000,"음식정보2","음식종류2");
        boolean isChange = foodChangeService.Change(food.getId(),dto);
        //then
        assertTrue(isChange);
        assertEquals(food.getName(), dto.getName());
        assertEquals(food.getPrice(), dto.getPrice());
        assertEquals(food.getInfo(), dto.getInfo());
        assertEquals(food.getCategory(), dto.getCategory());
    }

}