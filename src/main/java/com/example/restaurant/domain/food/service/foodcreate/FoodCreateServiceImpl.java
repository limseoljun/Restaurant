package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.controller.dto.food.FoodDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodCreateServiceImpl implements FoodCreateService {

    private final FoodRepository foodRepository;
    private final OwnerRepository
            ownerRepository;

    @Override
    public boolean Create(FoodDto dto, Long ownerId) {
        Optional<Owner> ownerOptional = ownerRepository.findById(ownerId);
        if (ownerOptional.isPresent()) {
            Food food = new Food(dto.getName(),
                    dto.getPrice(),
                    dto.getInfo(),
                    dto.getCategory(),
                    ownerOptional.get().getId()
            );
            foodRepository.save(food);
            return true;
        }
        return false;
    }
}
