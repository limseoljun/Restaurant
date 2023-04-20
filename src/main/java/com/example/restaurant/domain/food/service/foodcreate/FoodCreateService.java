package com.example.restaurant.domain.food.service.foodcreate;

import com.example.restaurant.domain.servicedto.food.FoodDto;
import org.springframework.web.multipart.MultipartFile;

public interface FoodCreateService {
    /**
     * DTO를 이용해서 Food 객체의 정보 생성한다.
     * restaurat 의 고유번호를 Food 의 객체에 저장한다.
     * imageUploadService 를 이용해 file 의 이미지 저장
     * @param dto (food 의 이름,가격,음식정보,종류 가 들어 있다)
     * @param restaurantId (restaurant 의 고유번호)
     * @param file (이미지 파일)
     * @return (생성되면 true 안되면 false 를 반환)
     */
    boolean create(FoodDto dto, Long restaurantId, MultipartFile file);
}
