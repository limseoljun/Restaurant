package com.example.restaurant.domain.order.menu.service.update;

import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.enums.OrderResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuListResultUpdateServiceImpl implements OrderMenuListResultUpdateService {
    private final OrderMenuRepository orderMenuRepository;

    @Override
    public void update(Long orderInId, String result) {
        List<OrderMenu> list = orderMenuRepository.findByOrderInId(orderInId);
        OrderResult orderResult = OrderResult.valueOf(result);

        for(OrderMenu orderMenu : list) {
            orderMenu.updateResult(orderResult.getResult());
        }
    }

}
