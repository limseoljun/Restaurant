package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodChangeServiceImpl implements FoodChangeService {
    private final FoodRepository foodRepository;

    @Override
    public boolean Change(Long foodId,FoodDto dto){
        Optional<Food> foodOptional = foodRepository.findById(foodId);
        if(foodOptional.isPresent()) {
            Food food = foodOptional.get();
            food.update(dto.getName(),
                    dto.getPrice(),
                    dto.getInfo(),
                    dto.getCategory()
            );
            return true;
        }
        return false;
    }
}
