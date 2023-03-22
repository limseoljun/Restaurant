 package com.example.restaurant.domain.order.menu.service.add;

import com.example.restaurant.domain.servicedto.ordermenu.OrderMenuDto;
import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

 @Service
@Transactional
@RequiredArgsConstructor
public class OrderMenuAddServiceImpl implements OrderMenuAddService{
    private final OrderMenuRepository orderMenuRepository;
    private final OrderInRepository orderInRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Override
    public void add(Long userId, OrderMenuDto dto) {
        User user = userRepository.validateUser(userId);
        Food food = foodRepository.validateFood(dto.getFoodId());
        OrderIn orderIn = orderInRepository.validateOrder(dto.getOrderId());
        OrderMenu existingOrderMenu = orderMenuRepository.existingOrderMenu(food.getId(), orderIn.getId());
        if(existingOrderMenu!=null){
            existingOrderMenu.update(dto.getCount(),getTime(),food);
        }else {
            OrderMenu orderMenu = new OrderMenu(
                    dto.getCount(),
                    getTime(),
                    user,
                    food,
                    orderIn
            );
            orderMenuRepository.save(orderMenu);
        }
    }
    private String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss"));
    }
}
