package com.example.restaurant.exception;

public class NotFoundOwnerException extends RuntimeException {
    public NotFoundOwnerException() {

        super("Invalid OwnerId");
    }
}
