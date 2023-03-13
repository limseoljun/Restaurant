package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperator;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodCreateServiceImpl implements FoodCreateService {

    private final FoodRepository foodRepository;
    private final RestaurantOperatorRepository
            restaurantOperatorRepository;

    @Override
    public boolean Create(FoodDto dto, Long restaurantId) {
        Optional<RestaurantOperator> operOptional = restaurantOperatorRepository.findById(restaurantId);
        if (operOptional.isPresent()) {
            Food food = new Food(dto.getName(),
                    dto.getPrice(),
                    dto.getInfo(),
                    dto.getCategory(),
                    operOptional.get().getId()
            );
            foodRepository.save(food);
            return true;
        }
        return false;
    }
}
