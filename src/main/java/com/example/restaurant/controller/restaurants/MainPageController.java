package com.example.restaurant.controller.restaurants;

import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("restaurantId")
@RequestMapping(value = "/restaurants/main")
public class MainPageController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping("")
    public String get(SessionStatus sessionStatus,Model model){
        sessionStatus.setComplete();
        List<Restaurant>list = restaurantRepository.findAll();
        model.addAttribute("restaurantList", list);
        return "thymeleaf/restaurants/main";
    }

    @PostMapping("")
    public String post(@RequestParam("restaurantId")Long restaurantId,Model model){
        model.addAttribute("restaurantId",restaurantId);
        return "redirect:/restaurants/user-order-page";
    }

}
