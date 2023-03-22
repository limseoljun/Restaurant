package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/owner/order-processing")
public class OwnerOrderProcessing {
    private final OrderMenuRepository orderMenuRepository;

    @GetMapping("")
    public String get(@Param("orderId")Long orderId, Model model){
        List<OrderMenu> orderMenuList=orderMenuRepository.findByOrderInId(orderId);
        model.addAttribute("orderMenuList",orderMenuList);
        return "thymeleaf/owner/order-processing";
    }
}
