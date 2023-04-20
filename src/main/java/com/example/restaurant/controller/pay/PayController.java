package com.example.restaurant.controller.pay;

import com.example.restaurant.domain.order.info.service.update.OrderResultUpdateService;
import com.example.restaurant.domain.order.menu.service.update.OrderMenuListUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/pay")
public class PayController {
    private final OrderResultUpdateService orderResultUpdateService;
    private final OrderMenuListUpdateService orderMenuListUpdateService;
    @PostMapping("")
    public String post(@SessionAttribute("userId")Long userId, @RequestParam("orderInId")Long orderInId,
                       @RequestParam("count")List<Integer> counts){
        orderMenuListUpdateService.update(counts,orderInId);
        orderResultUpdateService.update(userId,orderInId,"READY");
        return "thymeleaf/pay/pay";
    }
}
