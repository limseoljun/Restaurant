package com.example.restaurant.domain.order.menu.domain;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.order.info.domain.OrderIn;
import com.example.restaurant.domain.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int count;
    private int price;
    private String result;
    private String time;
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_in_id")
    private OrderIn orderIn;

    public OrderMenu(){}
    public OrderMenu(int count, String time, User user, Food food, OrderIn orderIn){
        this.count=count;
        this.price=food.getPrice()* count;
        this.user=user;
        this.orderIn = orderIn;
        this.food=food;
        this.time=time;
        this.result="Payment waiting";
    }
    public void update (int count, String time){
        this.count=count;
        this.price=food.getPrice()* count;
        this.time=time;
    }
    public void updateResult(String result){
        this.result=result;
    }
}
