package com.example.restaurant.exception;

public class PasswordEncodingFailedException extends RuntimeException {
    public PasswordEncodingFailedException() {
        super("Encoding Failed");
    }
}
