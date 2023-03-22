package com.example.restaurant.domain.food.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String info;
    private String category;
    private Long restaurantId;

    public Food(){
    }
    public Food(String name, int price, String info, String category,Long restaurantId){
        this.name=name;
        this.price=price;
        this.info=info;
        this.category=category;
        this.restaurantId=restaurantId;
    }
    public void update(String name,int price,String info,String category){
        this.name=name;
        this.price=price;
        this.info=info;
        this.category=category;
    }
}
