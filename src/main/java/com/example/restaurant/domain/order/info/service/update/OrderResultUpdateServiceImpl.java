package com.example.restaurant.domain.order.info.service.update;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.service.update.OrderMenuListResultUpdateService;
import com.example.restaurant.enums.OrderResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderResultUpdateServiceImpl implements OrderResultUpdateService {
    private final OrderInRepository orderInRepository;
    private final OrderMenuListResultUpdateService orderMenuListResultUpdateService;

    @Override
    public boolean update(Long userId,Long orderId, String result) {
        Optional<OrderIn> orderOptional = orderInRepository.findByIdAndUserId(orderId,userId);
        if(orderOptional.isPresent()) {
            OrderResult orderResult = OrderResult.valueOf(result);

            orderOptional.get().updateResult(orderResult.getResult());

            orderMenuListResultUpdateService.update(orderId, result);

            return true;
        }
        return false;
    }
}
