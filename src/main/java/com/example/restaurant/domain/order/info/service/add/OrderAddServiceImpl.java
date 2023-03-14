package com.example.restaurant.domain.order.info.service.add;

import com.example.restaurant.domain.order.info.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderAddServiceImpl implements OrderAddService {
    private final OrderRepository orderRepository;
    private final OrderAddService orderAddService;

    @Override
    public void add(){

    }
}
