package com.example.restaurant.domain.order.info.service.add;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
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
public class OrderAddServiceImpl implements OrderAddService {
    private final OrderInRepository orderInRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public Long add(Long userId, Long ownerId,Long restaurantId){
       User user = userRepository.validateUser(userId);
       Restaurant restaurant = restaurantRepository.validateOwnerIdAndRestaurantId(ownerId,restaurantId);

       OrderIn orderIn = new OrderIn(getTime(),user,restaurant);

       orderInRepository.save(orderIn);

       return orderIn.getId();
    }

    private  String getTime() {
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:ss"));
    }

}
