package com.example.restaurant.controller.restaurants;

import com.example.restaurant.controller.restaurants.dto.RestaurantUpdateControllerDto;
import com.example.restaurant.domain.image.service.ImageUploadService;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.restaurant.service.update.RestaurantUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants/update")
public class RestaurantUpdateController {
    private final RestaurantUpdateService restaurantUpdateService;
    private final RestaurantRepository restaurantRepository;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId")Long restaurantId, Model model){
        Optional<Restaurant>optionalRestaurant = restaurantRepository.findById(restaurantId);
        model.addAttribute("restaurant",optionalRestaurant.get());
        return "thymeleaf/restaurants/update";
    }

    @PostMapping("")
    public String post(@SessionAttribute("restaurantId")Long restaurantId, RestaurantUpdateControllerDto dto , MultipartFile file){
        if(restaurantUpdateService.update(restaurantId,dto.convertDto(),file)){
            return "redirect:/owner/my-restaurant";
        }
        return "redirect:/owner/my-restaurant";
    }
}
