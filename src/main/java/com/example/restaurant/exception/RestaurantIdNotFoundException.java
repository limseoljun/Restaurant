package com.example.restaurant.exception;

public class RestaurantIdNotFoundException extends RuntimeException {
    public RestaurantIdNotFoundException() {
        super("Invalid RestaurantId");
    }
}
