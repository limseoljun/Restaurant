package com.example.restaurant.enums;

import com.example.restaurant.exception.NotFoundErrorCodeException;
import lombok.Getter;

@Getter
public enum KoreanErrorCode {
    FOOD_MENU_NOT_FOUND("FOOD_NOT_FOUND","음식를 확인해주세요."),
    ORDER_NOT_FOUND("ORDER_NOT_FOUND","주문 리스트를 확인해주세요."),
    OWNER_NOT_FOUND("OWNER_NOT_FOUND","판매처를 확인해주세요."),
    OWNER_NAME_DUPLICATE("OWNER_NAME_DUPLICATE","판매처 이름이 중복됩니다."),
    OWNER_INFO_NOT_FOUND("OWNER_INFO_NOT_FOUND","판매처 정보를 확인해주세요."),
    RESTAURANT_NOT_FOUND("RESTAURANT_NOT_FOUND","식당을 확인해주세요."),
    USER_NAME_DUPLICATE("USER_NAME_DUPLICATE","아이디가 중복됩니다."),
    USER_INFO_NOT_FOUND("USER_INFO_NOT_FOUND","유저 정보를 확인해주세요."),
    METHOD_ARGUMENT("METHOD_ARGUMENT", "입력값 오류가 발생하였습니다.");

    private final String name;
    private final String result;

    KoreanErrorCode(String name,String result){
        this.name=name;
        this.result=result;
    }

    public static String findByResult(String name) {
        for(KoreanErrorCode koreanErrorCode : KoreanErrorCode.values()) {
            if(koreanErrorCode.name().equals(name)){
                return koreanErrorCode.result;
            }
        }
        throw new NotFoundErrorCodeException();
    }
}
