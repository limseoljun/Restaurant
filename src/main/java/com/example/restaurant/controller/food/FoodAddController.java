package com.example.restaurant.controller.food;

import com.example.restaurant.controller.food.dto.FoodAddControllerDto;
import com.example.restaurant.domain.food.service.foodcreate.FoodCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/food/add")
public class FoodAddController {
    private final FoodCreateService foodCreateService;

    /**
     * mapping 이 입력되면 view 페이지에 전달
     */
    @GetMapping("")
    public String get(){
        return "thymeleaf/food/add";
    }

    /**
     * 세션에 저장된 restaurantId 를 가져오고 FoodAddControllerDto 정보와 이미지 파일을 받음
     * Food 생성이 되면 식당 view 페이지로 가고 아니면 로그인 페이지로 이동하게 함
     */
    @PostMapping("")
    public String post(@SessionAttribute("restaurantId")Long restaurantId, FoodAddControllerDto dto, MultipartFile file){
        if(foodCreateService.create(dto.convertDto(), restaurantId,file)){
            return "redirect:/owner/my-restaurant";
        }
        return "redirect:/owner/login";
    }
}
