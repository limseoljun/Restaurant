package com.example.restaurant.domain.order.menu.service.update;

import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.enums.OrderResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuResultUpdateServiceImpl implements OrderMenuResultUpdateService {
    private final OrderMenuRepository orderMenuRepository;

    @Override
    public boolean update(Long userId,Long orderMenuId, String result) {
        Optional<OrderMenu> orderMenuOptional = orderMenuRepository.findByIdAndUserId(orderMenuId,userId);

        if(orderMenuOptional.isPresent()) {
            OrderResult orderResult = OrderResult.valueOf(result);
            orderMenuOptional.get().updateResult(orderResult.getResult());

            return true;
        }
        return false;
    }
}
