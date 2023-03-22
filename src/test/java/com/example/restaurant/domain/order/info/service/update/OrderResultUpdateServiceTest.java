package com.example.restaurant.domain.order.info.service.update;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderResultUpdateServiceTest {
    private final OrderResultUpdateService orderResultUpdateService;
    private final OrderInRepository orderInRepository;
    private final UserRepository userRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    OrderResultUpdateServiceTest(OrderResultUpdateService orderResultUpdateService, OrderInRepository orderInRepository, UserRepository userRepository, RestaurantRepository restaurantRepository) {
        this.orderResultUpdateService = orderResultUpdateService;
        this.orderInRepository = orderInRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    void 주문상태_업데이트_정상작동(){
        User user = new User("user","123","nick","000","Address");
        userRepository.save(user);
        Restaurant restaurant =new Restaurant("restaurant","Address","222",1L);
        restaurantRepository.save(restaurant);
        OrderIn orderIn = new OrderIn("time",user,restaurant);
        orderInRepository.save(orderIn);

        boolean isUpdate = orderResultUpdateService.update(user.getId(), orderIn.getId(),"READY");

        assertTrue(isUpdate);
        assertEquals("Ready", orderIn.getResult());
    }
}