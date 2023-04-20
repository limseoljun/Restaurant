package com.example.restaurant.controller.order;

import com.example.restaurant.controller.order.dto.OrderFoodControllerDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
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

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@SessionAttributes("orderInId")
@RequestMapping(value = "/order/food-select")
public class OrderFoodSelectController {
    private final RestaurantRepository restaurantRepository;
    private final OrderAddService orderAddService;
    private final OrderMoreAddService orderMoreAddService;
    private final OrderMenuAddService orderMenuAddService;
    private final OrderInRepository orderInRepository;
    private final FoodRepository foodRepository;

    /**
     * view에서 foodId 를 받아 food 객체를 찾아 모델에 넣음
     * session 초기화
     */
    @GetMapping("")
    public String get(@Param("foodId")Long foodId, SessionStatus sessionStatus, Model model){
        sessionStatus.setComplete();
        Optional<Food> food = foodRepository.findById(foodId);
        model.addAttribute("food",food.get());
        return "thymeleaf/order/food-select";
    }

    /**
     * view에서 userId 와 basketOrPay (장바구니 결제 여부) , 주문 정보를 받아 주문 리스트 생성
     * 주문 리스트가 존재하지 않으면 새로 리스트 생성 존재하면 원래 리스트를 가져와 추가
     * orderInId 세션 저장 모델로 넘김
     */
    @PostMapping("")
    public String post(@SessionAttribute("userId")Long userId, @RequestParam("basketOrPay")String basketOrPay,
                       OrderFoodControllerDto dto, Model model){
        Optional<Restaurant> restaurant = restaurantRepository.findById(dto.getRestaurantId());
        if (basketOrPay.equals("장바구니")) {
            Long orderInId = null;
            if(!orderInRepository.existsByUserIdAndResult(userId,"Payment waiting")){
                orderInId = orderAddService.add(userId, restaurant.get().getOwnerId(),restaurant.get().getId());
                orderMenuAddService.add(userId,dto.convertDto().convertOrderMenuDto(orderInId));
            }else{
                orderInId = orderMoreAddService.more(userId,dto.convertDto());
            }
            model.addAttribute("orderInId",orderInId);
            return "redirect:/restaurants/user-order-page";
        }
        return "redirect:/pay";
    }
}
