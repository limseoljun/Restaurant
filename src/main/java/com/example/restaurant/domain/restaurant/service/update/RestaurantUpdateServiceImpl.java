package com.example.restaurant.domain.restaurant.service.update;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantUpdateServiceImpl implements RestaurantUpdateService {
    private final RestaurantRepository restaurantRepository;
    @Override
    public boolean update (Long restaurantId, RestaurantDto dto){
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if(restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            restaurant.update(dto.getName(),
                    dto.getBusinessAddress(),
                    dto.getCallNum()
            );
            return true;
        }
        return false;
    }
}
