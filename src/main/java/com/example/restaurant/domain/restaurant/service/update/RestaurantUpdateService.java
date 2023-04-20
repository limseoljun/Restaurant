package com.example.restaurant.domain.restaurant.service.update;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantUpdateService {
    /**
     * restaurantId 를 받아 식당 객체를 가져옴
     * dto 값으로 업데이트
     * @param restaurantId 식당의 고유번호
     * @param dto 식당 이름, 주소 ,번호
     * @param file 이미지 파일
     * @return 업데이트 되면 true 안되면 false
     */
    boolean update (Long restaurantId, RestaurantDto dto, MultipartFile file);
}
