package com.example.restaurant.domain.owner.domain;

import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String restaurantName;
    private String restaurantAddress;

    public Owner(){
    }

    public Owner(String name, String password){
        this.name = name;
        this.password =password;
    }
    public Owner(String name, String password, String restaurantName, String restaurantAddress){
        this.name=name;
        this.password=password;
        this.restaurantName=restaurantName;
        this.restaurantAddress=restaurantAddress;
    }
    public boolean isValidPassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(password, this.password);
    }
    public boolean isEncodePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
        return passwordEncoder.matches(password, this.password);
    }
}
