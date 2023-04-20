package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
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
@RequestMapping(value = "/owner/order-page")
public class OwnerOrderPageController {
    private final OrderInRepository orderInRepository;
    private final OrderMenuRepository orderMenuRepository;

    @GetMapping("")
    public String get(@SessionAttribute("restaurantId") Long restaurantId, Model model) {
        List<OrderIn> orderInList = orderInRepository.findByResultAndRestaurantId("Ready", restaurantId);

            model.addAttribute("orderInList", orderInList);

        return "thymeleaf/order/owner-order-page";
    }
}
