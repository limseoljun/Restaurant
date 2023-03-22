package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.order.info.service.update.OrderResultUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/owner/result-cooking")
public class OwnerResultCooking {
        private final OrderResultUpdateService orderResultUpdateService;

        @GetMapping("")
        public String get(@Param("orderId")Long orderId, @Param("userId")Long userId){
            orderResultUpdateService.update(userId,orderId,"COOKING");
            return "redirect:/owner/my-restaurant";
        }
}
