package com.example.restaurant.exception;

public class NotFoundErrorCodeException extends RuntimeException {
    public NotFoundErrorCodeException(){
        super("NotFound ErrorCode Message");
    }
}
