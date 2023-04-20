package com.example.restaurant.controller.restaurants;

import com.example.restaurant.controller.owner.dto.ValidateOwnerControllerDto;
import com.example.restaurant.domain.owner.service.validateowner.ValidateOwnerService;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants/validate-update")
public class RestaurantValidateUpdateController {

    private final ValidateOwnerService validateOwnerService;
    private final RestaurantRepository restaurantRepository;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId") Long restaurantId, Model model) {
        model.addAttribute("updateRestaurantId", restaurantId);
        return "thymeleaf/owner/validate-owner";
    }

    @PostMapping("")
    public String post(ValidateOwnerControllerDto ownerDto,@SessionAttribute("restaurantId")Long restaurantId, Model model) {
        Long ownerId = validateOwnerService.validate(ownerDto.convertDto());
        Optional<Restaurant>optionalRestaurant=restaurantRepository.findById(restaurantId);
        if(ownerId==optionalRestaurant.get().getOwnerId()) {
            return "redirect:/restaurants/update";
        }
        return "redirect:/owner/my-restaurant";
    }

}
