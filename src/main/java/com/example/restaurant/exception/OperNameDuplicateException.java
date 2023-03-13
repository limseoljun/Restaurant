package com.example.restaurant.exception;

public class OperNameDuplicateException extends RuntimeException {
    public OperNameDuplicateException() {
        super("Duplicate Oper Name");
    }
}
