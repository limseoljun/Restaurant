package com.example.restaurant.controller.restaurants;

import com.example.restaurant.controller.owner.dto.RestaurantAddControllerDto;
import com.example.restaurant.domain.restaurant.service.add.RestaurantAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants/add")
public class RestaurantAddController {
    private final RestaurantAddService restaurantAddService;

    @GetMapping("")
    public String get(){
        return "thymeleaf/restaurants/add";
    }
    @PostMapping("")
    public String post(RestaurantAddControllerDto dto, @SessionAttribute Long ownerId, MultipartFile file){
        restaurantAddService.add(dto.convertDto(),ownerId,file);
        return "redirect:/owner/my-page";
    }

}
