package com.example.restaurant.domain.order.info.service.delete;

import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderDeleteServiceImpl implements OrderDeleteService {
    private final OrderInRepository orderInRepository;

    @Override
    public boolean delete(Long userId, Long orderId){
        if(orderInRepository.existsByUserIdAndId(userId, orderId)){

            orderInRepository.deleteById(orderId);

            return true;
        }
        return false;
    }

}
