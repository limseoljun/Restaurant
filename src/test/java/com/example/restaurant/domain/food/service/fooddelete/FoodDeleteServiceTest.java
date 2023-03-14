package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.owner.OwnerDto;
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
class FoodDeleteServiceTest {
    private final FoodRepository foodRepository;
    private final FoodDeleteService foodDeleteService;
    private final OwnerRepository ownerRepository;

    @Autowired
    FoodDeleteServiceTest(FoodRepository foodRepository, FoodDeleteService foodDeleteService, OwnerRepository ownerRepository) {
        this.foodRepository = foodRepository;
        this.foodDeleteService = foodDeleteService;
        this.ownerRepository = ownerRepository;
    }

    @Test
    void 삭제_정상작동(){
        Owner owner =  new Owner("owner","1234","restaurant","123");
        ownerRepository.save(owner);
        OwnerDto dto = new OwnerDto("owner","1234");
        Food food = new Food("name",1000,"info","category", owner.getId());
        foodRepository.save(food);

        boolean isDelete = foodDeleteService.Delete(food.getId(),dto);

        assertTrue(isDelete);
        assertFalse(foodRepository.existsById(food.getId()));
    }
}