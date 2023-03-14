package com.example.restaurant.exception;

public class OwnerNameAndPasswordDifferentException extends RuntimeException{
    public OwnerNameAndPasswordDifferentException() {

        super("Different Owner Name And Password");
    }
}
