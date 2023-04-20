package com.example.restaurant.domain.restaurant.service.delete;

import com.example.restaurant.domain.servicedto.owner.OwnerDto;

/**
 *
 */
public interface RestaurantDeleteService {
    /**
     * restaurantId 로 식당객체를 불러와 저장된 주인의 고유번호를 가져옴
     * dto 의 아이디로 주인의 객체를 찾아 고유번호를 가져옴
     * 두 고유번호가 같을때 dto 에 저장된 정보를 가지고 주인을 검증
     * restaurantId를 가진 식당 삭제
     * @param restaurantId 식당의 고유번호
     * @param dto 주인의 아이디 비밀번호
     * @return 삭제되면 true 안되면 false
     */
    boolean delete(Long restaurantId, OwnerDto dto);
}
