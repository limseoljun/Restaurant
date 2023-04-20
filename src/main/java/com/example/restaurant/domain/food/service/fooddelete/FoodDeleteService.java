package com.example.restaurant.domain.food.service.fooddelete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;
import com.example.restaurant.exception.NotFoundFoodException;
import com.example.restaurant.exception.NotFoundOwnerException;
import com.example.restaurant.exception.NotFoundRestaurantException;
import com.example.restaurant.exception.OwnerNameAndPasswordDifferentException;

public interface FoodDeleteService {
    /**
     *
     * @param foodId (food 의 고유번호)
     * @param dto (Owner 의 정보 name,password)
     * @return (삭제되면 ture 안되면 false)
     * @throws NotFoundFoodException foodId 로 객체를 찾지 못했을때
     * @throws NotFoundRestaurantException food 객체에서 가져온 restaurantId 로 restaurant 객체를 가져오지 못했을때
     * @throws NotFoundOwnerException dto 에서 가져온 Owner name 이 존재하지 않을때
     * @throws OwnerNameAndPasswordDifferentException dto 에서 가져온 Owner name password 가 존재하지 않을때
     */
    boolean delete(Long foodId, OwnerDto dto) throws OwnerNameAndPasswordDifferentException;
}
