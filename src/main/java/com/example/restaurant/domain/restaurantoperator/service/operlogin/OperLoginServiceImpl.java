package com.example.restaurant.domain.restaurantoperator.service.operlogin;

import com.example.restaurant.controller.dto.oper.OperDto;
import com.example.restaurant.domain.restaurantoperator.domain.RestaurantOperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OperLoginServiceImpl implements OperLoginService {
    private final RestaurantOperatorRepository restaurantOperatorRepository;

    @Override
    public void Login(OperDto dto){
       if(!restaurantOperatorRepository.existsByName(dto.getName())) {
           throw new BadCredentialsException("Validate Oper Name");
       } else if (!restaurantOperatorRepository.existsByPassword(dto.getPassword())){
            throw new BadCredentialsException("Validate Oper Pass");
        }
    }
}
