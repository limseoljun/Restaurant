package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.domain.servicedto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodCreateServiceImpl implements FoodCreateService {

    private final FoodRepository foodRepository;
    private final RestaurantRepository
            restaurantRepository;

    @Override
    public boolean Create(FoodDto dto, Long restaurantId) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Food food = new Food(dto.getName(),
                    dto.getPrice(),
                    dto.getInfo(),
                    dto.getCategory(),
                    restaurantOptional.get().getId()
            );
            foodRepository.save(food);
            return true;
        }
        return false;
    }
}
