package com.example.restaurant.controller.owner;

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
@RequestMapping(value = "/owner/my-page")
public class OwnerMyPageController {
    private final RestaurantRepository restaurantRepository;

    @GetMapping("")
    public String get(@SessionAttribute("ownerId") Long ownerId, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();
        List<Restaurant> restaurantList = restaurantRepository.findAllByOwnerId(ownerId);
        model.addAttribute("restaurantList", restaurantList);
        return "thymeleaf/owner/my-page";
    }
    @PostMapping("")
    public String post(@RequestParam("restaurantId")Long restaurantId,Model model){
        model.addAttribute("restaurantId",restaurantId);
        return "redirect:/owner/my-restaurant";
    }
}
