package com.example.restaurant.domain.restaurantoperator.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class RestaurantOperator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String restaurantName;
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
