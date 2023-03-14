package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.owner.OwnerDto;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodDeleteServiceImpl implements FoodDeleteService {
    private final FoodRepository foodRepository;
    private final ValidateOwnerService validateOwnerService;
    @Override
    public boolean Delete(Long foodId, OwnerDto dto){
        if(foodRepository.existsById(foodId)) {
            validateOwnerService.validte(dto);
            foodRepository.deleteById(foodId);
            return true;
        }
        return false;
    }
}
