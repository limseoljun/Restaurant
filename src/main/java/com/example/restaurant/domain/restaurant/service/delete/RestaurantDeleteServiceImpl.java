package com.example.restaurant.domain.restaurant.service.delete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantDeleteServiceImpl implements RestaurantDeleteService {
    private final RestaurantRepository restaurantRepository;
    private final ValidateOwnerService validateOwnerService;
    @Override
    public boolean delete(Long restaurantId, OwnerDto dto){
        if(restaurantRepository.existsById(restaurantId)) {
            validateOwnerService.validte(dto);
            restaurantRepository.deleteById(restaurantId);
            return true;
        }
        return false;
    }
}
