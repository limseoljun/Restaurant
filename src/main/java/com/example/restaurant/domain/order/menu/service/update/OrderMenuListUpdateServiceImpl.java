package com.example.restaurant.domain.order.menu.service.update;

import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuListUpdateServiceImpl  implements OrderMenuListUpdateService{
    private final OrderMenuRepository orderMenuRepository;

    @Override
    public void update(List<Integer> counts, Long orderInId){
        List<OrderMenu>optionalOrderMenu=orderMenuRepository.findByOrderInId(orderInId);
        if(!optionalOrderMenu.isEmpty()) {
            for (int i = 0; i < counts.size(); i++) {
                OrderMenu orderMenu = optionalOrderMenu.get(i);
                orderMenu.update(counts.get(i),getTime());
            }
        }
    }

    private String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss"));
    }
}
