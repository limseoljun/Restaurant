package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
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
    private final OwnerRepository ownerRepository;
    @Autowired
    FoodChangeServiceTest(FoodRepository foodRepository, FoodChangeService foodChangeService, OwnerRepository ownerRepository){
        this.foodRepository=foodRepository;
        this.foodChangeService = foodChangeService;
        this.ownerRepository = ownerRepository;
    }
    @Test
    void 음식_변경_정상작동() {
        //given
        Owner owner = new Owner("owner","1234","restaurant","123");
        ownerRepository.save(owner);
        Food food = new Food("food",1000,"info","category",owner.getId());
        foodRepository.save(food);
        //When
        FoodDto dto = new FoodDto("food2",2000,"info2","category2");
        boolean isChange = foodChangeService.Change(food.getId(),dto);
        //then
        assertTrue(isChange);
        assertEquals(food.getName(), dto.getName());
        assertEquals(food.getPrice(), dto.getPrice());
        assertEquals(food.getInfo(), dto.getInfo());
        assertEquals(food.getCategory(), dto.getCategory());
    }

}