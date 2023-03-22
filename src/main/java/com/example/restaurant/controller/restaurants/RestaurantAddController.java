package com.example.restaurant.controller.restaurants;

import com.example.restaurant.controller.owner.dto.RestaurantAddControllerDto;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.service.add.RestaurantAddService;
import com.example.restaurant.domain.servicedto.restaurant.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String post(RestaurantAddControllerDto dto, @SessionAttribute Long ownerId){
        restaurantAddService.add(dto.convertDto(),ownerId);
        return "redirect:/owner/my-page";
    }

}
