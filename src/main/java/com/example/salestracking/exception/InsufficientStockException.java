package com.example.salestracking.exception;

public class InsufficientStockException extends Throwable {
    public InsufficientStockException(String message) {
        super(message);
    }
}
