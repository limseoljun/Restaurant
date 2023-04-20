package com.example.restaurant.controller.restaurants;

import com.example.restaurant.controller.owner.dto.ValidateOwnerControllerDto;
import com.example.restaurant.domain.restaurant.service.delete.RestaurantDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants/delete")
public class RestaurantDeleteController {
    private final RestaurantDeleteService restaurantDeleteService;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId")Long restaurantId, Model model){
        model.addAttribute("deleteRestaurantId",restaurantId);
        return "thymeleaf/owner/validate-owner";
    }
    @PostMapping("")
    public String post(@SessionAttribute("restaurantId")Long restaurantId, ValidateOwnerControllerDto dto){
        if(restaurantDeleteService.delete(restaurantId,dto.convertDto())){
            return "redirect:/owner/my-page";
        }
        return "redirect:/owner/my-page";
    }
}
