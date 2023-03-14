package com.example.restaurant.domain.food.service.foodcreate;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FoodCreateServiceTest {
    private final FoodRepository foodRepository;
    private final FoodCreateService foodCreateService;
    private final OwnerRepository ownerRepository;
    @Autowired
    FoodCreateServiceTest(FoodRepository foodRepository, FoodCreateService foodCreateService, OwnerRepository ownerRepository) {
        this.foodRepository = foodRepository;
        this.foodCreateService = foodCreateService;
        this.ownerRepository = ownerRepository;
    }

    @Test
    void 생성_정상작동(){
        FoodDto dto = new FoodDto("name",1000,"info","category");
        Owner owner =  new Owner("owner","1234","restaurant","123");
        ownerRepository.save(owner);
        boolean isCreate = foodCreateService.Create(dto, owner.getId());
        List<Food> list = foodRepository.findByOwnerId(owner.getId());
        assertTrue(isCreate);
        assertEquals("name",list.get(0).getName());
        assertEquals(1000,list.get(0).getPrice());
        assertEquals("info",list.get(0).getInfo());
        assertEquals("category",list.get(0).getCategory());
    }
}