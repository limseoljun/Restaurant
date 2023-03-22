package com.example.restaurant.domain.order.menu.service.delete;

import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuDeleteServiceImpl implements OrderMenuDeleteService {
    private final OrderMenuRepository orderMenuRepository;

    @Override
    public boolean delete(Long userId, Long orderMenuId) {
        if (orderMenuRepository.existsByUserIdAndId(userId, orderMenuId)) {

            orderMenuRepository.deleteById(orderMenuId);

            return true;
        }
        return false;
    }
}
