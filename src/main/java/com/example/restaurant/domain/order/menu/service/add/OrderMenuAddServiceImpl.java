 package com.example.restaurant.domain.order.menu.service.add;

import com.example.restaurant.controller.dto.ordermenu.OrderMenuDTO;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.Order;
import com.example.restaurant.domain.order.info.domain.OrderRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuAddServiceImpl implements OrderMenuAddService{
    private final OrderMenuRepository orderMenuRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;

    @Override
    public void add(Long userId, OrderMenuDTO dto) {
        User user = userRepository.validateUser(userId);
        Food food = foodRepository.validateFood(dto.getFoodId());
        Order order = orderRepository.validateOrder(dto.getOrderId());

        OrderMenu orderMenu = new OrderMenu(
                dto.getCount(),
                user,
                food,
                order,
                getTime()
        );
        orderMenuRepository.save(orderMenu);

    }
    private String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss"));
    }
}
