package com.example.restaurant.controller.order;

import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/order/basket")
public class OrderBasketController {
    private final OrderMenuRepository orderMenuRepository;

    /**
     * view 에서 orderInId 를 받아서
     * List 를 불러와서 view 에 넘김
     */
    @GetMapping("")
    public String get(@RequestParam("orderInId")Long orderInId, Model model){
        List<OrderMenu> orderMenu=orderMenuRepository.findByOrderInId(orderInId);
        model.addAttribute("orderMenuList",orderMenu);
        return "thymeleaf/order/basket";
    }
}
