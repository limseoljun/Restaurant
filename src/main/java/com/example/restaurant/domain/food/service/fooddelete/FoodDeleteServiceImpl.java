package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.controller.dto.oper.OperDto;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.restaurantoperator.service.validateoper.ValidateOperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodDeleteServiceImpl implements FoodDeleteService {
    private final FoodRepository foodRepository;
    private final ValidateOperService validateOperService;
    @Override
    public boolean Delete(Long foodId, OperDto dto){
        if(foodRepository.existsById(foodId)) {
            validateOperService.validte(dto);
            foodRepository.deleteById(foodId);
            return true;
        }
        return false;
    }
}
