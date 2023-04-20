package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/owner/my-restaurant")
public class OwnerMyRestaurantController {
    private final RestaurantRepository restaurantRepository;
    private final OrderInRepository orderInRepository;
    private final FoodRepository foodRepository;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId") Long restaurantId, Model model) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
        List<OrderIn> orderInList = orderInRepository.findByResultAndRestaurantId("Ready", restaurantId);
        List<Food> foodList = foodRepository.findByRestaurantId(restaurantId);

        optionalRestaurant.ifPresent(value -> model.addAttribute("restaurantInfo", value));
        model.addAttribute("orderInList",null);
        if (orderInList != null) {
            model.addAttribute("orderInList", orderInList);
        }
        model.addAttribute("restaurantId", restaurantId);
        model.addAttribute("foodList", foodList);
        return "thymeleaf/owner/my-restaurant";
    }
}
