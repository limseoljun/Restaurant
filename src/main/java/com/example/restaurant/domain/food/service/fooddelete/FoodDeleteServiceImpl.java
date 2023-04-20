package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import com.example.restaurant.exception.NotFoundFoodException;
import com.example.restaurant.exception.NotFoundOwnerException;
import com.example.restaurant.exception.NotFoundRestaurantException;
import com.example.restaurant.exception.OwnerNameAndPasswordDifferentException;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class FoodDeleteServiceImpl implements FoodDeleteService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final ValidateOwnerService validateOwnerService;
    private final OwnerRepository ownerRepository;
    @Override
    public boolean delete(Long foodId, OwnerDto dto) throws OwnerNameAndPasswordDifferentException {
        if(foodRepository.existsById(foodId)) {
            Optional<Food>foodOptional=foodRepository.findById(foodId);
            if(foodOptional.isEmpty()){
                throw new NotFoundFoodException();
            }
            Food food = foodOptional.get();

            Optional<Restaurant>restaurantOptional=restaurantRepository.findById(food.getRestaurantId());
            if(restaurantOptional.isEmpty()){
                throw new NotFoundRestaurantException();
            }
            Restaurant restaurant = restaurantOptional.get();

            Optional<Owner>ownerOptional=ownerRepository.findByName(dto.getName());
            if(ownerOptional.isEmpty()){
                throw new NotFoundOwnerException();
            }
            Owner owner = ownerOptional.get();

            if(restaurant.getOwnerId()==owner.getId()) {
                validateOwnerService.validate(dto);
                foodRepository.deleteById(foodId);
                return true;
            }
        }
        return false;
    }
}
