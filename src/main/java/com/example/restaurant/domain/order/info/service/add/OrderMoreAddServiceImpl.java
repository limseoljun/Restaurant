package com.example.restaurant.domain.order.info.service.add;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.order.OrderDto;
import com.example.restaurant.domain.order.menu.service.add.OrderMenuAddService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMoreAddServiceImpl implements OrderMoreAddService{
    private final OrderMenuAddService orderMenuAddService;
    private final OrderInRepository orderInRepository;

    @Override
    public Long more(Long userId, OrderDto dto){
        Optional<OrderIn>orderIn=orderInRepository.findByUserIdAndResult(userId,"Payment waiting");
        Long orderId= orderIn.get().getId();
        orderMenuAddService.add(userId,dto.convertOrderMenuDto(orderId));

        return orderId;
    }
}
