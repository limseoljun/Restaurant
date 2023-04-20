package com.example.restaurant.domain.restaurant.service.delete;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantDeleteServiceImpl implements RestaurantDeleteService {
    private final RestaurantRepository restaurantRepository;
    private final OwnerRepository ownerRepository;
    private final ValidateOwnerService validateOwnerService;
    @Override
    public boolean delete(Long restaurantId, OwnerDto dto){
        Optional<Restaurant>optionalRestaurant=restaurantRepository.findById(restaurantId);
        Optional<Owner>optionalOwner=ownerRepository.findByName(dto.getName());
        if(optionalRestaurant.get().getOwnerId()==optionalOwner.get().getId()){
            validateOwnerService.validate(dto);
            restaurantRepository.deleteById(restaurantId);
            return true;
        }
        return false;
    }
}
