package com.example.restaurant.exception;

public class OperNameAndPasswordDifferentException extends RuntimeException{
    public OperNameAndPasswordDifferentException() {

        super("Different Oper Password");
    }
}
