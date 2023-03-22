package com.example.restaurant.exception;

public class NotFoundOrderException extends RuntimeException{
    public NotFoundOrderException() {

        super("Invalid OrderId");
    }
}
