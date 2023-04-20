package com.example.restaurant.domain.restaurant.service.add;

import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import org.springframework.web.multipart.MultipartFile;

public interface RestaurantAddService {
    /**
     * ownerId로 owner 객체가 존재하면 dto 의 정보와 이미지를 가지고 식당 생성
     * @param dto 식당이름,주소,번호
     * @param ownerId 주인의 고유번호
     * @param file 이미지 파일
     * @return 생성되면 true 안되면 false 반환
     */
    boolean add(RestaurantDto dto, Long ownerId, MultipartFile file);

}
