package com.example.restaurant.controller.advice;

import com.example.restaurant.enums.KoreanErrorCode;
import com.example.restaurant.exception.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
@ControllerAdvice
public class OwnerExceptionAdvice {
    /**
     * error-view 페이지로 이동할 상수 설정
     * message 설정
     */
    private static final  String VIEW_PAGE = "thymeleaf/error/error-page";
    private static final  String MODEL_NAME = "errorMessage";

    /**
     * 사업자 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(NotFoundOwnerException.class)
    public ModelAndView notFoundOwnerException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("OWNER_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * 사업자 이름 비밀번호 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(OwnerNameAndPasswordDifferentException.class)
    public ModelAndView ownerNameAndPasswordDifferentException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("OWNER_INFO_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * 사업자 이름 중복 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(OwnerNameDuplicateException.class)
    public ModelAndView ownerNameDuplicateException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("OWNER_NAME_DUPLICATE"));

        return modelAndView;
    }

    /**
     * 사업자 이름 오류 발생시 exception 처리를 받아 view 페이지에 message 전달
     */
    @ExceptionHandler(OwnerNameNotFoundException.class)
    public ModelAndView ownerNameNotFoundException() {
        ModelAndView modelAndView = new ModelAndView(VIEW_PAGE);
        modelAndView.addObject(MODEL_NAME, findByKoreanErrorCode("OWNER_INFO_NOT_FOUND"));

        return modelAndView;
    }

    /**
     * error message 를 받아 Enums 의 KoreanErrorCode 로 변환
     */
    private String findByKoreanErrorCode(String error) {
        return KoreanErrorCode.findByResult(error);
    }
}
