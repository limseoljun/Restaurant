package com.example.restaurant.domain.order.info.domain;

import com.example.restaurant.domain.restaurant.domain.Restaurant;
import com.example.restaurant.domain.user.domain.User;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String time;
    private String result;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public OrderIn(){}
    public OrderIn(String time, User user, Restaurant restaurant){
        this.time=time;
        this.user=user;
        this.restaurant=restaurant;
        this.result="Payment waiting";
    }

    public void updateResult(String result){
        this.result = result;
    }
}
