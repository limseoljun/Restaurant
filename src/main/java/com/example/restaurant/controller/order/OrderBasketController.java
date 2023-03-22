package com.example.restaurant.controller.order;

import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/order/basket")
public class OrderBasketController {
    private final OrderInRepository orderInRepository;
    private final OrderMenuRepository orderMenuRepository;
    @GetMapping("")
    public String get(@RequestParam("orderId")Long orderId, Model model){
        List<OrderMenu> orderMenu=orderMenuRepository.findByOrderInId(orderId);
        model.addAttribute("orderMenuList",orderMenu);
        return "thymeleaf/order/basket";
    }
}
