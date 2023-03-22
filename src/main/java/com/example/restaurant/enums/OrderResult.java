package com.example.restaurant.enums;

public enum OrderResult {
    PAYMENT_WAITING("Payment waiting"),
    READY("Ready"),
    COOKING("Cooking"),
    DELIVERED("Delivered"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String result;

    OrderResult(String result) {
        this.result =result;
    }

    public String getResult() {
        return result;
    }
}
