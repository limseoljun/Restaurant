package com.example.restaurant.domain.food.domain;

import com.example.restaurant.domain.image.ImageUpload;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Food implements ImageUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private String info;
    private String category;
    private Long restaurantId;
    private String imagePath;

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

    @Override
    public void uploadImage(String imagePath) {
        this.imagePath=imagePath;
    }
}
