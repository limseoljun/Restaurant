package com.example.restaurant.exception;

public class UserIdNotFoundException extends RuntimeException {
    public UserIdNotFoundException() {
        super("Invalid User Id");
    }
}
