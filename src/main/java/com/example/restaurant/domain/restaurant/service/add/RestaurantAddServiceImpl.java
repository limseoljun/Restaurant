package com.example.restaurant.domain.restaurant.service.add;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantAddServiceImpl implements RestaurantAddService{
    private final RestaurantRepository restaurantRepository;
    private final OwnerRepository ownerRepository;

    @Override
    public boolean add(RestaurantDto dto, Long ownerId){
        Optional<Owner> ownerOptional = ownerRepository.findById(ownerId);
        if (ownerOptional.isPresent()) {
            Restaurant restaurant = new Restaurant(dto.getName(),
                    dto.getBusinessAddress(),
                    dto.getCallNum(),
                    ownerOptional.get().getId()
            );
            restaurantRepository.save(restaurant);
            return true;
        }
        return false;
    }
}
