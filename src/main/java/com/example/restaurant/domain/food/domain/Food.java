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
    private Long price;
    private String info;
    public Food(){
    }
    public Food(String name,Long price,String info){
        this.name=name;
        this.price=price;
        this.info=info;
    }
}
