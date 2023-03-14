package com.example.restaurant.domain.order.menu.domain;

import com.example.restaurant.domain.food.domain.Food;
import com.example.restaurant.domain.order.info.domain.Order;
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
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderMenu(int count, User user, Food food, Order order, String time){}
    public OrderMenu(int count, int price, User user, Order order, Food food,String time){
        this.count=count;
        this.price=price;
        this.user=user;
        this.order=order;
        this.food=food;
        this.time=time;
        this.result="Received";
    }
    public void updateResult(String result){
        this.result=result;
    }
}
