package com.example.restaurant.exception;

public class OwnerNameDuplicateException extends RuntimeException {
    public OwnerNameDuplicateException() {
        super("Duplicate Owner Name");
    }
}
