package com.example.restaurant.exception;

public class UserNameDuplicateException extends RuntimeException {
    public UserNameDuplicateException() {
        super("Duplicate User Name");
    }
}
