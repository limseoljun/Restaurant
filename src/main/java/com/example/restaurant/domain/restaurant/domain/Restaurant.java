package com.example.restaurant.domain.restaurant.domain;

import com.example.restaurant.domain.image.ImageUpload;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Restaurant implements ImageUpload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String businessAddress;
    private String callNum;
    private Long ownerId;
    private String imagePath;
    public Restaurant(){

    }
    public Restaurant(String name,String businessAddress,String callNum,Long ownerId){
        this.name=name;
        this.businessAddress=businessAddress;
        this.callNum=callNum;
        this.ownerId=ownerId;
    }

    public void update(String name, String businessAddress, String callNum) {
        this.name = name;
        this.businessAddress =businessAddress;
        this.callNum = callNum;
    }

    @Override
    public void uploadImage(String imagePath) {
        this.imagePath=imagePath;
    }
}
