package com.example.restaurant.exception;

public class OwnerNameNotFoundException extends RuntimeException {
    public OwnerNameNotFoundException(String invalidOwner) {
        super("Invalid Owner Name");
    }
}
