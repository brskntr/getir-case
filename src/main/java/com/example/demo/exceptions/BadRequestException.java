package com.example.demo.exceptions;

/**
 * @author bariskantar
 */
public class BadRequestException extends RuntimeException{
    public BadRequestException(String msg){
        super(msg);
    }
}
