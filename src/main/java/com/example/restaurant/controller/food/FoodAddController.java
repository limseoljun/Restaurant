package com.example.restaurant.controller.food;

import com.example.restaurant.controller.food.dto.FoodAddControllerDto;
import com.example.restaurant.domain.food.service.foodcreate.FoodCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/food/add")
public class FoodAddController {
    private final FoodCreateService foodCreateService;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId")Long restaurantId, Model model){
        System.out.println("확인====="+restaurantId);
        model.addAttribute("getRestaurantId",restaurantId);
        return "thymeleaf/food/add";
    }
    @PostMapping("")
    public String post(@SessionAttribute("restaurantId")Long restaurantId, FoodAddControllerDto dto){
        if(foodCreateService.Create(dto.convertDto(), restaurantId)){
            return "redirect:/owner/my-restaurant";
        }
        return "redirect:/owner/login";
    }
}
