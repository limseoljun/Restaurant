package com.example.restaurant.domain.order.menu.service.update;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.food.domain.FoodRepository;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.order.info.domain.OrderInRepository;
import com.example.restaurant.domain.order.menu.domain.OrderMenu;
import com.example.restaurant.domain.order.menu.domain.OrderMenuRepository;
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

@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderMenuListResultUpdateServiceTest {
        private final OrderMenuListResultUpdateService orderMenuListResultUpdateService;
        private final OrderMenuRepository orderMenuRepository;
        private final UserRepository userRepository;
        private final RestaurantRepository restaurantRepository;
        private final FoodRepository foodRepository;
        private final OrderInRepository orderInRepository;

        @Autowired
        OrderMenuListResultUpdateServiceTest(OrderMenuListResultUpdateService orderMenuListResultUpdateService, OrderMenuRepository orderMenuRepository, UserRepository userRepository, RestaurantRepository restaurantRepository, FoodRepository foodRepository, OrderInRepository orderInRepository) {
        this.orderMenuListResultUpdateService = orderMenuListResultUpdateService;
        this.orderMenuRepository = orderMenuRepository;
        this.userRepository = userRepository;
                this.restaurantRepository = restaurantRepository;
                this.foodRepository = foodRepository;
                this.orderInRepository = orderInRepository;
        }

        @Test
        void 주문_전체상태_변경(){
                User user = new User("name,","123","nick","000","Address");
                userRepository.save(user);

                Restaurant restaurant =new Restaurant("Restaurant","BAddress","000",1L);
                restaurantRepository.save(restaurant);

                OrderIn orderIn =new OrderIn("time",user,restaurant);
                orderInRepository.save(orderIn);

                Food food = new Food("food",1000,"info","category",restaurant.getId());
                Food food2 = new Food("food2",2000,"info2","category2", restaurant.getId());
                foodRepository.save(food);
                foodRepository.save(food2);

                OrderMenu orderMenu = new OrderMenu(2,"time",user,food,orderIn);
                OrderMenu orderMenu2 = new OrderMenu(3,"time",user,food2,orderIn);
                orderMenuRepository.save(orderMenu);
                orderMenuRepository.save(orderMenu2);

                orderMenuListResultUpdateService.update(orderIn.getId(), "READY");

                assertEquals("Ready",orderMenu.getResult());
                assertEquals("Ready",orderMenu2.getResult());
        }
}