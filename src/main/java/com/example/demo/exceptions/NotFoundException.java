package com.example.demo.exceptions;

/**
 * @author bariskantar
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) {
        super(msg);
    }
}
