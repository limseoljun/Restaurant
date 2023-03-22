package com.example.restaurant.controller.order;

import com.example.restaurant.controller.order.dto.OrderFoodControllerDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.info.service.add.OrderAddService;
import com.example.restaurant.domain.order.info.service.add.OrderMoreAddService;
import com.example.restaurant.domain.order.menu.service.add.OrderMenuAddService;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@SessionAttributes("orderId")
@RequestMapping(value = "/order/food-select")
public class OrderFoodSelectController {
    private final RestaurantRepository restaurantRepository;
    private final OrderAddService orderAddService;
    private final OrderMoreAddService orderMoreAddService;
    private final OrderMenuAddService orderMenuAddService;
    private final OrderInRepository orderInRepository;
    private final FoodRepository foodRepository;

    @GetMapping("")
    public String get(@Param("foodId")Long foodId, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();
        Optional<Food> food = foodRepository.findById(foodId);
        model.addAttribute("food",food.get());
        return "thymeleaf/order/food-select";
    }

    @PostMapping("")
    public String post(@SessionAttribute("userId")Long userId, @RequestParam("basketOrPay")String basketOrPay,
                       OrderFoodControllerDto dto, Model model){
        Optional<Restaurant> restaurant = restaurantRepository.findById(dto.getRestaurantId());
        if (basketOrPay.equals("장바구니")) {
            Long orderId = 0L;
            if(!orderInRepository.existsByUserIdAndResult(userId,"Payment waiting")){
                orderId = orderAddService.add(userId, restaurant.get().getOwnerId());
                orderMenuAddService.add(userId,dto.convertDto().convertOrderMenuDto(orderId));
            }else{
                orderId = orderMoreAddService.more(userId,dto.convertDto());
            }
            model.addAttribute("orderId",orderId);
            return "redirect:/restaurants/user-order-page";
        }
        return "redirect:/pay";
    }
}
