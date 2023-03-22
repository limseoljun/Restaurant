package com.example.restaurant.domain.order.info.service.delete;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderDeleteServiceTest {
    private final OrderDeleteService orderDeleteService;
    private final OrderInRepository orderInRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    OrderDeleteServiceTest(OrderDeleteService orderDeleteService, OrderInRepository orderInRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.orderDeleteService = orderDeleteService;
        this.orderInRepository = orderInRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    void 주문_삭제_정상작동(){
        User user = new User("name","1234","nick","000","Address");
        userRepository.save(user);
        Restaurant restaurant = new Restaurant("restaurant","BAddress","222",1L);
        restaurantRepository.save(restaurant);
        OrderIn orderIn = new OrderIn("time",user,restaurant);
        orderInRepository.save(orderIn);

        boolean isDelete = orderDeleteService.delete(user.getId(),orderIn.getId());

        assertTrue(isDelete);
        assertFalse(orderInRepository.existsById(orderIn.getId()));
    }
}