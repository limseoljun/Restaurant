package com.example.restaurant.exception;

public class NotFoundFoodException extends RuntimeException{
    public NotFoundFoodException() {

        super("Invalid FoodId");
    }
}
