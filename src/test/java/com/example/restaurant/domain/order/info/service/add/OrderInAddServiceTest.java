package com.example.restaurant.domain.order.info.service.add;

import static org.junit.jupiter.api.Assertions.*;

import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.restaurant.domain.RestaurantRepository;
import com.example.restaurant.domain.servicedto.order.OrderDto;
import com.example.restaurant.domain.user.domain.User;
import com.example.restaurant.domain.user.domain.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderInAddServiceTest {
    private final OrderInRepository orderInRepository;
    private final UserRepository userRepository;
    private final OrderAddService orderAddService;
    private final RestaurantRepository restaurantRepository;
    @Autowired
    OrderInAddServiceTest(OrderInRepository orderInRepository, UserRepository userRepository, OrderAddService orderAddService, RestaurantRepository restaurantRepository) {
        this.orderInRepository = orderInRepository;
        this.userRepository = userRepository;
        this.orderAddService = orderAddService;
        this.restaurantRepository = restaurantRepository;
    }

    @Test
    void 주문_생성_정상작동(){
        User user = new User("user","1234","nick","000","Address");
        userRepository.save(user);
        Restaurant restaurant = new Restaurant("restaurant","BAddress","111",1L);
        restaurantRepository.save(restaurant);

        orderAddService.add(user.getId(),restaurant.getOwnerId());
        OrderIn orderIn = orderInRepository.findByUserId(user.getId()).get(0);

        assertEquals(orderIn.getRestaurant(),restaurant);
        assertEquals(orderIn.getUser(),user);
        assertEquals(orderIn.getResult(),"Payment waiting");
        assertNotNull(orderIn.getTime());
    }

}