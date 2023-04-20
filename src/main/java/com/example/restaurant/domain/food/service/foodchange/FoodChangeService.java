package com.example.restaurant.domain.food.service.foodchange;

import com.example.restaurant.domain.servicedto.food.FoodDto;
import org.springframework.web.multipart.MultipartFile;

public interface FoodChangeService {
    /**
     * food 의 고유번호를 통해 Food 의 객체를 가져온다.
     * DTO를 이용해서 Food 객체의 정보 변경한다.
     * imageUploadService 를 이용해 file 의 이미지 저장
     * @param foodId (food 의 고유번호)
     * @param dto (food 의 이름,가격,음식정보,종류 가 들어 있다)
     * @param file (이미지 파일)
     * @return (바뀌면 true 안바뀌면 false 를 반환)
     */
    boolean change(Long foodId, FoodDto dto, MultipartFile file);
}
