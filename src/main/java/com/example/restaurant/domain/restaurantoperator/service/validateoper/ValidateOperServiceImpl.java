package com.example.restaurant.domain.restaurantoperator.service.validateoper;

import com.example.restaurant.controller.dto.oper.OperDto;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperatorRepository;
import com.example.restaurant.exception.OperNameAndPasswordDifferentException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ValidateOperServiceImpl implements ValidateOperService {
    private final RestaurantOperatorRepository restaurantOperatorRepository;
    @Override
    public void validte(OperDto dto) {
        if (!restaurantOperatorRepository.existsByNameAndPassword(dto.getName(),dto.getPassword())){
            throw new OperNameAndPasswordDifferentException();
        }
    }
}
