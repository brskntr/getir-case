package com.example.demo.exceptions;

/**
 * @author bariskantar
 */
public class DuplicateException extends RuntimeException{
    public DuplicateException(String msg){
        super(msg);
    }
}
