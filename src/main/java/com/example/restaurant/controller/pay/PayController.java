package com.example.restaurant.controller.pay;

import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.info.service.update.OrderResultUpdateService;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.domain.order.menu.service.update.OrderMenuListResultUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/pay")
public class PayController {
    private final OrderResultUpdateService orderResultUpdateService;
    @GetMapping("")
    public String get(@SessionAttribute("userId")Long userId, @Param("orderId")Long orderId){
        orderResultUpdateService.update(userId,orderId,"READY");
        return "redirect:/restaurants/main";
    }
}
