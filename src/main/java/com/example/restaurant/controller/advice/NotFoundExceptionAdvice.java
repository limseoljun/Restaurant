package com.example.restaurant.controller.advice;

import com.example.restaurant.enums.KoreanErrorCode;
import com.example.restaurant.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class NotFoundExceptionAdvice {
    /**
     * error-view 페이지로 이동할 상수 설정
     * message 설정
     */
    private static final  String VIEW_PAGE = "thymeleaf/error/error-page";
    private static final  String MODEL_NAME = "errorMessage";

    /**
     * 식당 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(NotFoundRestaurantException.class)
    public ModelAndView notFoundRestaurantException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("RESTAURANT_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * 음식 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(NotFoundFoodException.class)
    public ModelAndView notFoundFoodException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("FOOD_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * 주문 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(NotFoundOrderException.class)
    public ModelAndView notFoundOrderException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("ORDER_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * 식당 고유번호 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(RestaurantNotFoundException.class)
    public ModelAndView restaurantIdNotFountException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("RESTAURANT_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * error message 를 받아 Enums 의 KoreanErrorCode 로 변환
     */
    private String findByKoreanErrorCode(String error) {
        return KoreanErrorCode.findByResult(error);
    }
}
