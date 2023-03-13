package com.example.restaurant.domain.restaurantoperator.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RestaurantOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "restaurant_name")

    private String restaurantName;
    @Column(name = "restaurant_address")

    private String restaurantAddress;

    public RestaurantOperator(){
    }

    public RestaurantOperator(String name,String password){
        this.name = name;
        this.password =password;
    }
    public RestaurantOperator(String name,String password,String restaurantName,String restaurantAddress){
        this.name=name;
        this.password=password;
        this.restaurantName=restaurantName;
        this.restaurantAddress=restaurantAddress;
    }
}
