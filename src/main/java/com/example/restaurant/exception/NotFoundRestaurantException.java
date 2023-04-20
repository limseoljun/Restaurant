package com.example.restaurant.exception;

public class NotFoundRestaurantException extends RuntimeException {
    public NotFoundRestaurantException() {

        super("Invalid Restaurant");
    }
}
