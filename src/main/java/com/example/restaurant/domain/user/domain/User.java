package com.example.restaurant.domain.user.domain;

import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickName;
    private String password;
    private String phoneNum;
    private String homeAddress;
    public User() {
    }
    public User(String name, String password){
        this.name = name;
        this.password = password;
    }
    public User(String name, String password, String nickName, String phoneNum,String homeAddress){
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.phoneNum = phoneNum;
        this.homeAddress = homeAddress;
    }
    public boolean isValidPassword(PasswordEncoder passwordEncoder, String password) {
        return passwordEncoder.matches(password, this.password);
    }
    public boolean isEncodePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
        return passwordEncoder.matches(password, this.password);
    }
}
