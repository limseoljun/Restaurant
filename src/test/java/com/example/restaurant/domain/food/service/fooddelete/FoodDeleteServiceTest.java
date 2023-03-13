package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.controller.dto.oper.OperDto;
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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodDeleteServiceTest {
    private final FoodRepository foodRepository;
    private final FoodDeleteService foodDeleteService;
    private final RestaurantOperatorRepository restaurantOperatorRepository;

    @Autowired
    FoodDeleteServiceTest(FoodRepository foodRepository, FoodDeleteService foodDeleteService, RestaurantOperatorRepository restaurantOperatorRepository) {
        this.foodRepository = foodRepository;
        this.foodDeleteService = foodDeleteService;
        this.restaurantOperatorRepository = restaurantOperatorRepository;
    }

    @Test
    void 삭제_정상작동(){
        RestaurantOperator operator =  new RestaurantOperator("oper","1234","restaurant","123");
        restaurantOperatorRepository.save(operator);
        OperDto dto = new OperDto("oper","1234");
        Food food = new Food("name",1000,"info","category",operator.getId());
        foodRepository.save(food);
        System.out.println("확인==="+food.getId());
        System.out.println("확인==="+dto.getName());
        System.out.println("확인==="+dto.getPassword());
        boolean isDelete = foodDeleteService.Delete(food.getId(),dto);

        assertTrue(isDelete);
        assertFalse(foodRepository.existsById(food.getId()));
    }
}