package com.example.restaurant.domain.restaurantoperator.service.operjoin;

import com.example.restaurant.controller.dto.oper.OperDto;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperator;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OperJoinServiceImpl implements OperJoinService {
    private final RestaurantOperatorRepository restaurantOperatorRepository;

    @Override
    public void Join(OperDto dto){
        RestaurantOperator oper = new RestaurantOperator(dto.getName(),dto.getPassword(),dto.getRestaurantName(),dto.getRestaurantAddress());
        restaurantOperatorRepository.save(oper);
    }
}
