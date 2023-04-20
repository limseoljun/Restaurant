package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.owner.domain.Owner;
import com.example.restaurant.domain.owner.domain.OwnerRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@SessionAttributes("restaurantId")
@RequestMapping(value = "/owner/my-page")
public class OwnerMyPageController {
    private final RestaurantRepository restaurantRepository;
    private final OwnerRepository ownerRepository;

    @GetMapping("")
    public String get(@SessionAttribute("ownerId") Long ownerId, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();
        Optional<Owner>optionalOwner = ownerRepository.findById(ownerId);
        List<Restaurant> restaurantList = restaurantRepository.findAllByOwnerId(ownerId);
        model.addAttribute("ownerName" , optionalOwner.get().getName());
        model.addAttribute("restaurantList", restaurantList);
        return "thymeleaf/owner/my-page";
    }
    @PostMapping("")
    public String post(@RequestParam("restaurantId")Long restaurantId,Model model){
        model.addAttribute("restaurantId",restaurantId);
        return "redirect:/owner/my-restaurant";
    }
}
