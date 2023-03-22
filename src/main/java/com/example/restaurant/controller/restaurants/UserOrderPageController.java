package com.example.restaurant.controller.restaurants;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurants/user-order-page")
public class UserOrderPageController {
    private final FoodRepository foodRepository;
    private final OrderInRepository orderInRepository;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId") Long restaurantId,
                      @SessionAttribute("userId") Long userId,
                      Model model ){
        if(orderInRepository.existsByUserIdAndResult(userId,"Payment waiting")){
            Optional<OrderIn>orderIn=orderInRepository.findByUserIdAndResult(userId, "Payment waiting");
            Long orderId = orderIn.get().getId();
            model.addAttribute("orderId",orderId);
        }
        List<Food> foodList = foodRepository.findByRestaurantId(restaurantId);
            model.addAttribute("foodList",foodList);
        return "thymeleaf/restaurants/user-order-page";
    }
}
