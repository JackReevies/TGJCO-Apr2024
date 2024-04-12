package com.version1.Exceptions;

public class InvalidOperandException extends RuntimeException {
    public InvalidOperandException(String msg){
        super(msg);
    }
}
