package com.example.restaurant.controller.owner;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/owner/order-processing")
public class OwnerOrderProcessingController {
    private final OrderMenuRepository orderMenuRepository;
    private final OrderInRepository orderInRepository;
    @PostMapping("")
    public String post(@Param("orderInId")Long orderInId, Model model){
        List<OrderMenu> orderMenuList=orderMenuRepository.findByOrderInId(orderInId);
        Optional<OrderIn> orderIn = orderInRepository.findById(orderInId);
        model.addAttribute("orderMenuList",orderMenuList);
        model.addAttribute("orderIn",orderIn.get());
        return "thymeleaf/order/order-processing";
    }
}
